package org.anefdef.supplier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class FileReadingThread extends Thread {

    final BlockingQueue<String> queue;

    public FileReadingThread(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public synchronized void run() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("src/org/anefdef/resources/input.txt"))){
            String line;
            while ((line = fileReader.readLine()) != null) {
                queue.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

