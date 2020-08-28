package org.anefdef.supplier;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class FileReadingThread extends Thread {

    final BlockingQueue<String> queue;
    BufferedReader br;

    public FileReadingThread(BlockingQueue<String> queue, BufferedReader br) {
        this.queue = queue;
        this.br = br;
    }

    @Override
    public synchronized void run() {
        try {
            String line;
            while ((line = br.readLine()) != null) {
                queue.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

