package com.sbt.javaschool.rnd;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorList<String> implements Iterable
{
    private ArrayList arrayList;
    private int currentSize;

    public IteratorList(ArrayList newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.size()-1;
    }

    @Override
    public Iterator<String> iterator() {
        Iterator<String> iterator = new Iterator<String>() {

            private int currentIndex = currentSize;

            @Override
            public boolean hasNext() {
                return currentIndex > 0 && arrayList.get(currentIndex) != null;
            }

            @Override
            public String next() {
                return (String) arrayList.get(currentIndex--);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return iterator;
    }
}