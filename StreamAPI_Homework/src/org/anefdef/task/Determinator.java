package org.anefdef.task;

import java.util.stream.IntStream;

public class Determinator {

    /**
     * Determines whether the number is prime.
     * @param n int number >= 2
     * @return true if number is prime.
     */

    public boolean isPrime(int n) {

        return IntStream.
                rangeClosed(2, (int) Math.sqrt(n)).
                noneMatch(value -> n % value == 0);
    }
}

