package org.anefdef;

public class OneElementBlockingQueue {

    final Object readerMutex = new Object();
    final Object writerMutex = new Object();

    volatile String element = null;

    public String removeLast() throws InterruptedException {

        synchronized (readerMutex) {
            while (element == null) {
                readerMutex.wait();
            }
        }
        synchronized (writerMutex) {
            String res = element;
            element = null;
            writerMutex.notify();
            return res;
        }
    }

    public void addFirst(String line) throws InterruptedException {

        synchronized (writerMutex) {
            while (element != null) {
                writerMutex.wait();
            }
        }
        synchronized (readerMutex) {
            element = line;
            readerMutex.notify();
        }
    }
}
