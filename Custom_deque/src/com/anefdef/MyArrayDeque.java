package com.anefdef;

import java.util.Iterator;

public class MyArrayDeque<T> implements MyDeque<T>{

    int size;
    int firstIndex;
    final int capacity;

    final Object[] source;

    public MyArrayDeque(int capacity) {
        this.capacity = capacity;
        source = new Object[capacity];
    }

    @Override
    public void addLast(T e) {
        if (size == capacity) {
            throw new MyDequeOverflowException("Array out of capacity");
        } else {
            int nextIndex = (firstIndex + size++) % capacity;
            source[nextIndex] = e;
        }
    }

    @Override
    public void addFirst(T e) {
        if (size == capacity) {
            throw new MyDequeOverflowException("Array out of capacity");
        } else {
            if (firstIndex > 0) {
                firstIndex--;
            } else {
                firstIndex = capacity - 1;
            }
            source[firstIndex] = e;
            size++;
        }
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            throw new MyDequeEmptyException("Nothing to remove. Array is empty");
        } else {
            int lastIndex = (firstIndex + size-- - 1) % capacity;
            return (T) source[lastIndex];
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            throw new MyDequeEmptyException("Nothing to remove. Array is empty");
        } else {
            T result = (T) source[firstIndex];
            firstIndex = (firstIndex + 1) % capacity;
            size--;
            return result;
        }
    }

    @Override
    public T getFirst() {
        if (size == 0)
            throw new MyDequeEmptyException("Nothing to return. Array is empty");
        return (T) source[firstIndex];
    }

    @Override
    public T getLast() {
        if (size == 0)
            throw new MyDequeEmptyException("Nothing to return. Array is empty");
        int lastIndex = (firstIndex + size - 1) % capacity;
        return (T) source[lastIndex];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new DefaultIterator();
    }

    private class DefaultIterator<T> implements Iterator<T> {


        /**
         * the number of the current element from 0 to size - 1
         */

        int currentIndexNumber;

        @Override
        public boolean hasNext() {
            return currentIndexNumber < size;
        }

        @Override
        public T next() {
            int indexInSourceToReturn = (firstIndex + currentIndexNumber) % capacity;
            currentIndexNumber++;
            return (T) source[indexInSourceToReturn];
        }
    }
}






















