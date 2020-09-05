package org.anefdef.task;

import java.util.stream.LongStream;

public class Factorial {

    public long getF(int n) {
        return LongStream.rangeClosed(1,n).reduce((x, y) -> x * y).getAsLong();
    }
}
