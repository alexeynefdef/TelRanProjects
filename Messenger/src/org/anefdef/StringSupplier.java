package org.anefdef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSupplier extends Thread {

    private final OneElementBlockingQueue queue;

    public StringSupplier(OneElementBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((!line.equals("exit"))) {
            try {
                line = br.readLine();
                queue.addFirst(line);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
            this.interrupt();
        }
    }
}
