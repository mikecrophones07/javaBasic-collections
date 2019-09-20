package com.cultivation.javaBasic.showYourIntelligence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class DistinctIterable<T> implements Iterable<T> {
    private Iterable<T> iterable;

    public DistinctIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return new DistinctIterator<>(iterable.iterator());
    }

    public List<T> toList() {
        ArrayList<T> result = new ArrayList<>();
        this.forEach(result::add);

        return result;
    }
}

class DistinctIterator<E> implements Iterator<E> {
    // TODO: Implement the class to pass the test. Note that you cannot put all items into memory or you will fail.
    // <--start
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final Iterator<E> iterator;
    private Integer distinct = 2;
    private Integer distinctCnt = 0;
    private List<String> temp = new ArrayList<>();

    DistinctIterator(Iterator<E> iterator) {
        this.iterator = iterator;
    }


    @Override
    public boolean hasNext() {
        return distinctCnt != distinct;
    }

    @Override
    public E next() {
        E current = iterator.next();
        if(temp.size() == 0){
            String tempStr = String.valueOf(current);
            temp.add(tempStr);
            distinctCnt++;
            return current;
        }
        else{
            boolean flag = false;
            while (!flag) {
                String tempStr = String.valueOf(current);
                if(!temp.contains(tempStr)){
                    temp.add(tempStr);
                    distinctCnt++;
                    flag = true;
                }
                else {
                    current = iterator.next();
                }
            }
            return current;
        }
    }

}