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
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(line != null && !line.equals("exit")) {
            try {
                queue.addFirst(line);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
