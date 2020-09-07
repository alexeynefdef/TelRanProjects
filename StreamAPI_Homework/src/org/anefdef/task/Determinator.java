package org.anefdef.task;

import java.util.stream.IntStream;

public class Determinator {

    public boolean isPrime(int n) {

        return IntStream.rangeClosed(2, n / 2).noneMatch(i -> n % i == 0);
    }
}

