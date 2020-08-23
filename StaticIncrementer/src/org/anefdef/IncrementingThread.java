package org.anefdef;

public class IncrementingThread extends Thread {
    final Object mutex = new Object();


    private final int timesToIncrement;

    public IncrementingThread(int timesToIncrement) {
        this.timesToIncrement = timesToIncrement;
    }

    @Override
    public void run() {
        for (int i = 0; i < timesToIncrement; i++) {
            StaticIncrementer.incrementer();
        }
    }
}
