package com.anefdef;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class SectionInLine {
    /**
     * Method that determines most valuable accuracies of limit in List
     *
     * @param numbers sorted List of the positive numbers (double)
     * @param l limit or section (double)
     * @return Deque with numbers (double)
     * */

    public int findMaxSection(List<Double> numbers, double l) {
        Deque<Double> currentL = new ArrayDeque<>();
        int max = 0;

        for (double d:numbers) {
            currentL.addLast(d);
            var end = d - l;
            while (currentL.getFirst() < end) {
                currentL.removeFirst();
            }
            if (max < currentL.size()) {
                max = currentL.size();
            }
        }
        return max;
    }
}
