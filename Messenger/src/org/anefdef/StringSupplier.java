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
        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                String line = br.readLine();
                queue.addFirst(line);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
