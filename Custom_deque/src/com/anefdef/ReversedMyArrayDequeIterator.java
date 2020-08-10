package com.anefdef;

import java.util.Iterator;

public class ReversedMyArrayDequeIterator<T> implements Iterator<T> {

    MyArrayDeque<T> toIterate;
    /**
     * can be size-1 down to 0
     */
    int currentOrderNumber;

    public ReversedMyArrayDequeIterator(MyArrayDeque<T> toIterate) {
        this.toIterate = toIterate;
        currentOrderNumber = toIterate.size-1;
    }

    @Override
    public boolean hasNext() {
        return currentOrderNumber >= 0;
    }

    @Override
    public T next() {
        int indexInSourceToReturn = (toIterate.firstIndex + currentOrderNumber--) % toIterate.capacity;
        return (T) toIterate.source[indexInSourceToReturn];
    }
}
