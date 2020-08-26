package org.anefdef;

import org.anefdef.consumer.LineConsumer;
import org.anefdef.consumer.operation.LowerCaseOperation;
import org.anefdef.consumer.operation.ReverseOperation;
import org.anefdef.consumer.operation.StringOperation;
import org.anefdef.consumer.operation.UpperCaseOperation;
import org.anefdef.supplier.FileReadingThread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {

        Map<String, StringOperation> operationByName = new HashMap<>();
        operationByName.put("upper_case",new UpperCaseOperation());
        operationByName.put("lower_case",new LowerCaseOperation());
        operationByName.put("reverse",new ReverseOperation());

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);

        Thread reader1 = new FileReadingThread(queue);
        Thread reader2 = new FileReadingThread(queue);
        Thread reader3 = new FileReadingThread(queue);

        Thread writer1 = new LineConsumer(queue,operationByName);
        Thread writer2 = new LineConsumer(queue,operationByName);
        Thread writer3 = new LineConsumer(queue,operationByName);

        reader1.start();
        reader2.start();
        reader3.start();

        writer1.start();
        writer2.start();
        writer3.start();

    }
}
