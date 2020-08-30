package org.anefdef;

import org.anefdef.consumer.LineConsumer;
import org.anefdef.consumer.OperationStorage;
import org.anefdef.supplier.FileReadingThread;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    private static final String OPERATION_PROPS_PATH = "src/org/anefdef/config/operations.props";
    private static final String DEFAULT_INPUT_FILE = "src/org/anefdef/resources/input.txt";
    private static final String DEFAULT_OUTPUT_FILE = "src/org/anefdef/resources/output.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException {

        OperationProperties properties = new OperationProperties(OPERATION_PROPS_PATH);
        properties.load();

        List<String> operationPath = properties.getOperationPath();

        OperationStorage operationStorage = new OperationStorage();
        operationStorage.init(operationPath);

        BufferedReader fileReader = new BufferedReader(new FileReader(DEFAULT_INPUT_FILE));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(DEFAULT_OUTPUT_FILE));

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        LineConsumer[] consumers = new LineConsumer[3];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new LineConsumer(queue,operationStorage,fileWriter);
            consumers[i].start();
        }

        FileReadingThread[] suppliers = new FileReadingThread[3];
        for (int i = 0; i < suppliers.length; i++) {
            suppliers[i] = new FileReadingThread(queue,fileReader);
            suppliers[i].start();
        }
    }
}
