package com.anefdef;

import java.util.Iterator;

public class ReversedMyArrayDequeIterator<T> implements Iterator<T> {

    MyArrayDeque<T> toIterate;
    int currentIndexNumber;

    public ReversedMyArrayDequeIterator(MyArrayDeque<T> toIterate) {
        this.toIterate = toIterate;
        currentIndexNumber = toIterate.size;
    }

    @Override
    public boolean hasNext() {
        return currentIndexNumber > 0;
    }

    @Override
    public T next() {
        if (toIterate.size == 0)
            throw new MyDequeEmptyException("Empty source");
        int indexInSourceToReturn = (toIterate.firstIndex + currentIndexNumber - 1) % toIterate.capacity;
        currentIndexNumber--;
        return (T) toIterate.source[indexInSourceToReturn];
    }
}
