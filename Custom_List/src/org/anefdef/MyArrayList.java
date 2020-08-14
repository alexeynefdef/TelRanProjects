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
        //source = newSource;
        source = Arrays.copyOf(source, source.length * 2);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            T toRemove = (T) source[index];
            System.arraycopy(source, index + 1, source, index, size - 1 - index);
            size--;
            return toRemove;
        }
    }

    @Override
    public boolean remove(T element) {
        int index = getIndexOf(element);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        return (T) source[index];
    }

    @Override
    public boolean contains(T element) {
        int index = getIndexOf(element);
        return index != -1;
    }

    /**
     * searches index of the element in collection
     *
     * @param element to find in collection
     * @return actual index or -1 if not found
     */
    private int getIndexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (source[i].equals(element))
                return i;
        }
        return -1;
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
        Arrays.sort(source);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort(Comparator<T> comparator) {
        Arrays.sort((T[]) source,0,source.length,comparator);
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {
            int currentIndex;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                return (T) source[currentIndex++];
            }
        };
    }
}
