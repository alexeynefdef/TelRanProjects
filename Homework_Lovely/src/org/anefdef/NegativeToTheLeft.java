package org.anefdef;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NegativeToTheLeft {
    /**
     * Method witch edits a List of integers so,
     * that after editing you have all negative values
     * on the left side but you save the original order of elements.
     *
     * @param digits list of Integers < 0 and > 0
     * @return new List<Integer>
     */
    public List<Integer> toTheLeft(List<Integer> digits) {
        if (!digits.isEmpty()) {
            List<Integer> negative = new ArrayList<>();
            List<Integer> positive = new ArrayList<>();
            for (int i:digits) {
                if (i<0) {
                  negative.add(i);
                } else {
                    positive.add(i);
                }
            }
            negative.addAll(positive);
            return negative;
        }
        return null;
    }

    public List<Integer> subZeroLeft(List<Integer> digits) {
        if (!digits.isEmpty()) {
            List<Integer> output = new ArrayList<>();
            SubZeroLeftIterator it = new SubZeroLeftIterator(digits);
            while (it.hasNext()) {
                output.add((Integer) it.next());
            }
            return output;
        }
        return null;
    }
}
