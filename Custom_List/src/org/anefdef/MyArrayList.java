package org.anefdef;

import java.util.Arrays;
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

    static final int INITIAL_CAPACITY = 16;
    Object[] source;
    int size;

    public MyArrayList() {
        this.source = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int preferInitialCapacity) {
        this.source = new Object[preferInitialCapacity];
        this.size = 0;
    }

    @Override
    public void add(T element) {
        if (size == source.length) {
            increaseSource();
        }
        source[size++] = element;
    }

    private void increaseSource() {
        //Object[] newSource = new Object[source.length * 2];
        //System.arraycopy(source,0,newSource,0,source.length);
        source = Arrays.copyOf(source,source.length*2);
        //source = newSource;
    }

    @Override
    public T remove(int index) {
        T toRemove;
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            toRemove = (T) source[index];
            if (size - 1 - index >= 0) System.arraycopy(source, index + 1, source, index, size - 1 - index);
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
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        return (T) source[index];
    }

    @Override
    public boolean contains(T element) {
        try {
            for (int i = 0; i < size; i++) {
                if (source[i].equals(element))
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
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        source[index] = element;
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
