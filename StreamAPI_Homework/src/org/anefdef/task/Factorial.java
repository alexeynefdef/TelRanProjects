package org.anefdef.task;

import java.util.stream.LongStream;

public class Factorial {
    /**
     *
     * @param n > 0
     * @return !n
     */
    public long getF(int n) {
        return LongStream.
                rangeClosed(2, n).
                reduce(1,(res, current) -> res * current);
    }
}
