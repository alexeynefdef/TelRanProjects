package org.anefdef.consumer;

import org.anefdef.consumer.operation.StringOperation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.regex.PatternSyntaxException;

public class LineConsumer extends Thread {

    BlockingQueue<String> queue;
    Map<String, StringOperation> operationByName;

    public LineConsumer(BlockingQueue<String> queue, Map<String,StringOperation> operationByName) {
        this.queue = queue;
        this.operationByName = operationByName;
    }

    @Override
    public void run() {
        try {
            String line;
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/org/anefdef/resources/output.txt"));
            while (!queue.isEmpty()) {
                line = queue.take();
                queue.remove(line);
                try {
                    String[] splitLine = line.split("#");
                    String text = splitLine[0];
                    String operationName = splitLine[1];
                    StringOperation operation = operationByName.get(operationName);
                    String res = operation.operate(text);
                    fileWriter.write(res);
                    fileWriter.newLine();
                } catch (PatternSyntaxException e) {
                    fileWriter.write(line + ": Invalid line (No such delimiter #)");
                } catch (NullPointerException e) {
                    fileWriter.write(line + "Invalid line (no such command)");
                }
            }
            fileWriter.close();
            System.out.println("Operation finished successfully");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
