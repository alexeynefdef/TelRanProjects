package org.anefdef.consumer;

import org.anefdef.consumer.operation.StringOperation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class LineConsumer extends Thread {

    BlockingQueue<String> queue;
    Map<String, StringOperation> operationByName;
    BufferedWriter br;

    public LineConsumer(BlockingQueue<String> queue,
                        Map<String,StringOperation> operationByName,
                        BufferedWriter br) {
        this.queue = queue;
        this.operationByName = operationByName;
        this.br = br;
    }

    @Override
    public void run() {
        try {
            String line;
            while (!queue.isEmpty()) {
                line = queue.take();
                queue.remove(line);
                try {
                    String[] splitLine = line.split("#");
                    String text = splitLine[0];
                    String operationName = splitLine[1];
                    StringOperation operation = operationByName.get(operationName);
                    String res = operation.operate(text);
                    br.write(res);
                    br.newLine();
                } catch (ArrayIndexOutOfBoundsException e) {
                    br.write(line + ": Invalid line (No such delimiter #)");
                    br.newLine();
                } catch (NullPointerException e) {
                    br.write(line + ": Invalid line (no such command)");
                    br.newLine();
                }
            }
            System.out.println("Operation finished successfully");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
