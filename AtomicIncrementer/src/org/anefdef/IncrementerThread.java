package org.anefdef;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementerThread extends Thread {

    private final AtomicInteger incrementer;
    private final int times;

    public IncrementerThread(AtomicInteger incrementer, int times) {
        this.incrementer = incrementer;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            incrementer.incrementAndGet();
        }
    }
}
