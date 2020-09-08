package org.anefdef.task;

import java.util.stream.IntStream;

public class StreamCombination {

    public IntStream combine(IntStream streamA, IntStream streamB) {
        return IntStream.
                concat(streamB,streamA).
                filter(x -> x % 3 == 0 || x % 5 == 0).
                sorted().skip(2);
    }
}
