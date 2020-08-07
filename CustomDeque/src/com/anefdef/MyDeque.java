package com.anefdef;

/**
 * An interface of deque with limited capacity.
 * The implementations must contain a constructor accepting
 * the max number of elements.
 * @param <T>
 */

public interface MyDeque<T> extends Iterable<T> {

    void addLast(T e);

    void addFirst(T e);

    T removeLast();

    T removeFirst();

    T getFirst();

    T getLast();

    int size();
}
