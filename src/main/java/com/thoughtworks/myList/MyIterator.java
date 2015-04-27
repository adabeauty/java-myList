package com.thoughtworks.myList;

import java.util.Iterator;

/**
 * Created by hgwang on 4/27/15.
 */
public class MyIterator<E> implements Iterator<E> {

    Object[] myList;
    int nextIndex;

    public MyIterator(E[] myList) {
        this.myList = myList;
    }

    @Override
    public boolean hasNext() {

        return nextIndex < myList.length;
    }

    @Override
    public E next() {
        if(nextIndex >= myList.length)
            throw new IndexOutOfBoundsException("只有" + myList.length + "元素");
        return (E) myList[nextIndex++];
    }
}
