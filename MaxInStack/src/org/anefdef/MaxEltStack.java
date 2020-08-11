package org.anefdef;

import org.anefdef.exception.CustomStackEmptySourceException;

import java.util.ArrayDeque;
import java.util.Comparator;

public class MaxEltStack<T> {

    ArrayDeque<T> elements;
    ArrayDeque<T> maxValues;
    Comparator<T> comparator;

    public MaxEltStack() {
        this.elements = new ArrayDeque<>();
        this.maxValues = new ArrayDeque<>();
    }

    public MaxEltStack(Comparator<T> comparator) {
        this.comparator = comparator;
        elements = new ArrayDeque<>();
        maxValues = new ArrayDeque<>();
    }

    public void addLast(T element) {
        if (elements.size() == 0) {
            elements.addLast(element);
            maxValues.addLast(element);
        } else {
            T lastMax = maxValues.getLast();
            if (comparator != null && comparator.compare(lastMax,element) <= 0 ||
                    ((Comparable<T>) lastMax).compareTo(element) <= 0) {
                maxValues.addLast(element);
            }
            elements.addLast(element);
        }
    }

    public T removeLast() {
        if (elements.size() == 0) {
            throw new CustomStackEmptySourceException();
        }
        T lastElement = elements.removeLast();

        if (comparator != null &&
                (comparator.compare(lastElement,maxValues.getLast()) == 0) ||
                ((Comparable<T>)lastElement).compareTo(maxValues.getLast()) == 0 ){
            maxValues.removeLast();
        }

        return lastElement;
    }

    public T getLast() {
        if (elements.size() == 0) {
            throw new CustomStackEmptySourceException();
        }
        return elements.getLast();
    }

    public T getMax() {
        if (elements.size() == 0)
            throw new CustomStackEmptySourceException();
        return maxValues.getLast();
    }

    public int size() {
        return elements.size();
    }
}
