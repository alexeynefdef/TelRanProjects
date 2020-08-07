package com.anefdef;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CoveredPointsFinder {

    public int findMaxSection(List<Double> points,double l) {
        Deque<Double> section = new ArrayDeque<>(points);
        int max = 0;

        for (double point:points) {
            double leftEnd = point - l;
            section.addLast(point);
            while(section.getFirst() < leftEnd) {
                section.removeFirst();
            }
            if (section.size() > max)
                max = section.size();
        }
        return max;
    }
}
