package org.anefdef.task;

import java.util.stream.LongStream;

public class OddSum {

    public long getSomOfOddDigits(int a, int b) {
        return LongStream.range(a,b).filter(x -> x % 2 != 0).reduce(Long::sum).getAsLong();
    }
}
