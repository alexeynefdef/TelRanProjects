package org.anefdef;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        OneElementBlockingQueue queue = new OneElementBlockingQueue();

        Thread sup = new StringSupplier(queue);

        Thread[] consumers = new StringConsumer[5];
        for (int i = 0; i < 5; i++) {
            consumers[i] = new StringConsumer(queue);
            consumers[i].setDaemon(true);
            consumers[i].start();
        }
        sup.start();
    }
}
