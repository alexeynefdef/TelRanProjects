package org.anefdef;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        long startTimestamp = System.currentTimeMillis();

        Thread th = new CharPrinter('$',50);

        Thread th1 = new CharPrinter('%',50);

        Thread th2 = new CharPrinter('§',50);

        th.start();
        th1.start();
        th2.start();

        /*th.join();
        th1.join();
        th2.join();*/

        long endTimestamp = System.currentTimeMillis();
        System.out.println(endTimestamp - startTimestamp);
    }
}
