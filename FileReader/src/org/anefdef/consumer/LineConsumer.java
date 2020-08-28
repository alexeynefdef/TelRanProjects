package org.anefdef.consumer;

import org.anefdef.consumer.operation.StringOperation;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class LineConsumer extends Thread {

    BlockingQueue<String> queue;
    OperationStorage storage;
    PrintWriter fileWriter;

    public LineConsumer(BlockingQueue<String> queue,
                        OperationStorage storage,
                        PrintWriter fileWriter) {
        this.queue = queue;
        this.storage = storage;
        this.fileWriter = fileWriter;
    }

    @Override
    public void run() {
        try {
            String line;
            // change while
            while (!queue.isEmpty()) {
                line = queue.take();
                queue.remove(line);
                try {
                    String[] splitLine = line.split("#");
                    String text = splitLine[0];
                    String operationName = splitLine[1];
                    StringOperation operation = storage.getByName(operationName);
                    String res = operation.operate(text);
                    fileWriter.println(res);
                    fileWriter.flush();
                } catch (ArrayIndexOutOfBoundsException e) {
                    fileWriter.println(line + ": Invalid line (No such delimiter #)");
                    fileWriter.println();
                    fileWriter.flush();
                } catch (NullPointerException e) {
                    fileWriter.println(line + ": Invalid line (no such command)");
                    fileWriter.println();
                    fileWriter.flush();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
