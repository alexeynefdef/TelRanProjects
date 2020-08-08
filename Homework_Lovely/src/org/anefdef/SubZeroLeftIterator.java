package org.anefdef;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubZeroLeftIterator<Integer> implements Iterator<Integer> {

    private List<Integer> toIterate;
    private int currentIteration;

    public SubZeroLeftIterator(List<Integer> input) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (Integer n:input) {
            if ((int) n < 0) {
                left.add(n);
            } else {
                right.add(n);
            }
        }
        left.addAll(right);
        this.toIterate = left;
    }

    @Override
    public boolean hasNext() {
        return currentIteration < toIterate.size();
    }

    @Override
    public Integer next() {
        return toIterate.get(currentIteration++);
    }
}
