package org.anefdef;

public class Main {

    private static final int TIMES_TO_INCREMENT = 100000;

    public static void main(String[] args) throws InterruptedException {
        StaticIncrementer incrementer = new StaticIncrementer();

        Thread th1 = new IncrementingThread(TIMES_TO_INCREMENT);
        Thread th2 = new IncrementingThread(TIMES_TO_INCREMENT);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println(incrementer.getCounter());
    }
}
