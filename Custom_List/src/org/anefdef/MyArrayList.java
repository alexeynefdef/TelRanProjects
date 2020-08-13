package org.anefdef;

import java.util.Comparator;
import java.util.Iterator;

/**
 * The implementation of the List data structure via Array under the hood.
 * Initial Array length is 16.
 * In a case of overloading creating a new Array with doubled capacity of the old Array's length.
 * @param <T> is willing data Type
 */

public class MyArrayList<T> implements MyList<T>{

    Object[] source;

    @Override
    public void add(T element) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public void set(int index, T element) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public boolean contains(T element) {
        return false;
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
