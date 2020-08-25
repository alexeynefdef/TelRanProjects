package org.anefdef;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        OneElementBlockingQueue queue = new OneElementBlockingQueue();

        Thread sup = new StringSupplier(queue);
        Thread con1 = new StringConsumer(queue);
        Thread con2 = new StringConsumer(queue);
        Thread con3 = new StringConsumer(queue);

        con1.setDaemon(true);
        con2.setDaemon(true);
        con3.setDaemon(true);

        sup.start();
        con1.start();
        con2.start();
        con3.start();

        sup.join();
        con1.join();
        con2.join();
        con3.join();
    }
}
