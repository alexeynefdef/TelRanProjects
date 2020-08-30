package org.anefdef.consumer;

import org.anefdef.consumer.operation.StringOperation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class LineConsumer extends Thread {

    BlockingQueue<String> queue;
    OperationStorage storage;
    BufferedWriter fileWriter;

    public LineConsumer(BlockingQueue<String> queue,
                        OperationStorage storage,
                        BufferedWriter fileWriter) {
        this.queue = queue;
        this.storage = storage;
        this.fileWriter = fileWriter;
    }

    @Override
    public synchronized void run() {
        try {
            String line;
            while (true) {
                line = queue.take();
                if (line.equals("End of file")) return;
                try {
                    String[] splitLine = line.split("#");
                    String text = splitLine[0];
                    String operationName = splitLine[1];
                    StringOperation operation = storage.getByName(operationName);
                    String res = operation.operate(text);
                    fileWriter.write(res);
                    fileWriter.newLine();
                    fileWriter.flush();
                } catch (ArrayIndexOutOfBoundsException e) {
                    fileWriter.write(line + ": Invalid line (No such delimiter #)");
                    fileWriter.newLine();
                    fileWriter.flush();
                } catch (NullPointerException e) {
                    fileWriter.write(line + ": Invalid line (no such command)");
                    fileWriter.newLine();
                    fileWriter.flush();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
