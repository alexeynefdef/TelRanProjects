package com.anefdef;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyCustomStack implements CustomStack{
    /**
     * Custom simple Stack implementation
     */
    private int size;
    private int lastElement;
    private Deque<Integer> source;
    private Deque<Integer> maxElement;

    public MyCustomStack() {
        source = new ArrayDeque<>();
        maxElement = new ArrayDeque<>();
        size = 0;
    }

    @Override
    public void addLast(int i) {
        source.addLast(i);
        lastElement = i;
        size++;
        if (maxElement.size() == 0 || i > maxElement.getLast()) {
            maxElement.addLast(i);
        } else {
            maxElement.addLast(maxElement.getLast());
        }
    }

    @Override
    public int removeLast() {
        if (size == 0) {
            throw new CustomStackEmptySourceException();
        } else {
            int out = source.getLast();
            source.removeLast();
            maxElement.removeLast();
            if (size > 1){
                lastElement = source.getLast();
            }
            size--;
            return out;
        }
    }

    @Override
    public int getMax() {
        if (size == 0) {
            throw new CustomStackEmptySourceException();
        } else {
            return maxElement.getLast();
        }
    }

    @Override
    public int getLast() {
        if (size == 0) {
            throw new CustomStackEmptySourceException();
        } else {
            return source.getLast();
        }
    }

    @Override
    public int size() {
        return size;
    }
}
