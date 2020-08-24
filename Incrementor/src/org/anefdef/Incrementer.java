package org.anefdef;

import java.util.concurrent.atomic.AtomicInteger;

public class Incrementer {

    final Object mu1 = new Object();
   // final Object mu2 = new Object();

    private int counter;
    private AtomicInteger counter2;

    public synchronized void increment() {
        counter++;
    }

    public void increment2() {
        counter2.incrementAndGet();
    }

    public int getCounter() {
        return counter;
    }

    public int getCounter2() {
        return counter2.get();
    }
}
