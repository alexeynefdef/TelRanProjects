package org.anefdef;

import java.util.Comparator;
import java.util.Iterator;

/**
 * The implementation of the List data structure via Array under the hood.
 * Initial Array length is 16.
 * In a case of overloading creating a new Array with doubled capacity of the old Array's length.
 *
 * @param <T> is willing data Type
 */

public class MyArrayList<T> implements MyList<T> {

    Object[] source;
    int size;

    public MyArrayList() {
        this.source = new Object[16];
        this.size = 0;
    }

    public MyArrayList(int initialCapacity) {
        this.source = new Object[initialCapacity];
        this.size = 0;
    }

    @Override
    public void add(T element) {
        if (size == source.length) {
            Object[] temp = new Object[source.length * 2];
            for (int i = 0; i < source.length; i++) {
                temp[i] = source[i];
            }
            source = temp;
        }
        source[size++] = element;
    }

    @Override
    public T remove(int index) {
        T toRemove;
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            toRemove = (T) source[index];
            for (int i = index; i <= size; i++) {
                source[i] = source[i + 1];
            }
            size--;
        }
        return toRemove;
    }

    @Override
    public boolean remove(T element) {
        if (this.contains(element)) {
            for (int i = 0; i <= size; i++) {
                if (source[i].equals(element)) {
                    this.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException();
        return (T) source[index];
    }

    @Override
    public boolean contains(T element) {
        try {
            for (Object o : source) {
                if (o.equals(element))
                    return true;
            }
        } catch (NullPointerException nullPointerException) {
            return false;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, T element) {

    }

    @Override
    public void sort() {
    }

    @Override
    public void sort(Comparator<T> comparator) {
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
