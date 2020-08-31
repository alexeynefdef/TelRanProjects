package org.anefdef.consumer;

import org.anefdef.consumer.operation.StringOperation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class LineConsumer extends Thread {

    public static final String STOP_COMMAND = "End of file";
    static final String DELIMITER = "#";
    static final String INVALID_LINE = "Invalid line format. No such delimiter: ";
    static final String WRONG_OPERATION = "No such operation";
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
                String result = processLine(line);

                fileWriter.write(result);
                fileWriter.newLine();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Accepts line transforms it to another line.
     * Line should contain two parts separated by delimiter{@code DELIMITER}.
     * The first part is the text to operate on.
     * The second part is the name of the operation to perform.
     *
     * @param line String in format <text>#<operation_name>
     * @return transformed text according to the operation, if
     * the line satisfies to the requirements.
     * If the amount of parts in the line is not equal to two,
     * then <line>" Invalid line" should return.
     * If the operation not found , then
     * <line>"#Operation No such operation" should return.
     */
    String processLine(String line) {
        String[] splitLine = line.split(DELIMITER);
        if (splitLine.length != 2) {
            return line + " | " + INVALID_LINE + DELIMITER;
        }

        String text = splitLine[0];
        String operationName = splitLine[1];

        StringOperation operation = storage.getByName(operationName);

        if (operation == null) {
            return line + " | " + WRONG_OPERATION;
        }
        return operation.operate(text);
    }
}
