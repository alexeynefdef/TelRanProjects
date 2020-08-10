package org.anefdef;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayNegativeToPositiveIterator implements Iterator<Integer> {

    ArrayList<Integer> buffer;

    public ArrayNegativeToPositiveIterator(int[] source) {
        init(source);
    }

    public void init(int[] source) {
        buffer = new ArrayList<>();

        List<Integer> positive = new ArrayList<>();

        for (int num:source) {
            if (num < 0)
                buffer.add(num);
            else
                positive.add(num);
        }
        buffer.addAll(positive);
    }

    int currentIndex;

    @Override
    public boolean hasNext() {
        return currentIndex < buffer.size();
    }

    @Override
    public Integer next() {
        int currentNum = buffer.get(currentIndex++);

        return currentNum;
    }
}
