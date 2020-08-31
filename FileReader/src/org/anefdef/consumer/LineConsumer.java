package org.anefdef.consumer;

import org.anefdef.consumer.operation.StringOperation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class LineConsumer extends Thread {

    public static final String STOP_COMMAND = "End of file";
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
    public void run() {
        try {
            while (true) {
                String line = queue.take();
                if (line.equals(STOP_COMMAND))
                    return;
                try {
                    String[] splitLine = line.split("#");
                    String text = splitLine[0];
                    String operationName = splitLine[1];
                    StringOperation operation = storage.getByName(operationName);
                    String res = operation.operate(text);
                    fileWriter.write(res);
                    fileWriter.newLine();
                } catch (ArrayIndexOutOfBoundsException e) {
                    fileWriter.write(line + ": Invalid line (No such delimiter #)");
                    fileWriter.newLine();
                } catch (NullPointerException e) {
                    fileWriter.write(line + ": Invalid line (no such command)");
                    fileWriter.newLine();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
