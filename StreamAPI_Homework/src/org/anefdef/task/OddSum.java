package org.anefdef.task;

import java.util.stream.LongStream;

public class OddSum {

    /**
     * @param a <= b int number
     * @param b int number
     * @return sum of all odd numbers in range from a to b.
     * If there is no odd numbers in the interval, then return 0.
     */

    public long getSomOfOddDigits(int a, int b) {
        return LongStream.
                rangeClosed(a, b).
                filter(x -> x % 2 != 0).
                sum();
    }
}
