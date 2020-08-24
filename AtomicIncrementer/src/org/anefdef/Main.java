package org.anefdef;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger atomicNum = new AtomicInteger();
        Thread th1 = new IncrementerThread(atomicNum,100_000);
        Thread th2 = new IncrementerThread(atomicNum,100_000);

        th1.start();
        th2.start();

        th1.join();
        th1.join();

        System.out.println(atomicNum.get());
    }
}
