package org.anefdef;

public class Incrementer {

    final Object mu1 = new Object();
    final Object mu2 = new Object();

    private int counter;
    private int counter2;

    public synchronized void increment() {
        counter++;
    }

    public synchronized void increment2() {
        counter2++;
    }

    public int getCounter() {
        return counter;
    }

    public int getCounter2() {
        return counter2;
    }
}
