package org.anefdef.consumer;

import org.anefdef.consumer.operation.StringOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedWriter;
import java.util.concurrent.BlockingQueue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LineConsumerTest {

    LineConsumer consumer;

    BlockingQueue<String> queue;
    BufferedWriter fileWriter;
    OperationStorage storage;

    @BeforeEach
    void init() {
        queue = mock(BlockingQueue.class);
        fileWriter = mock(BufferedWriter.class);
        storage = mock(OperationStorage.class);
        consumer = new LineConsumer(queue,storage,fileWriter);
    }

    @Test
    void testProcessFile_textWithoutDelimiter_invalidLine() {
        String toProcess = "Hello";
        String expected = "Hello" + " | " + LineConsumer.INVALID_LINE + LineConsumer.DELIMITER;
        assertEquals(expected,consumer.processLine(toProcess));
    }

        @Test
    void testProcessFile_textWith2Delimiter_invalidLine() {
        String toProcess = "Hello#some_operation#addition";
        String expected = toProcess + " | " + LineConsumer.INVALID_LINE + LineConsumer.DELIMITER;
        assertEquals(expected,consumer.processLine(toProcess));
    }



    @Test
    void testProcessFile_textWithIncorrectOperation_invalidLine() {
        String toProcess = "Hello#some_operation";
        String expected = "Hello#some_operation" + " | " + LineConsumer.WRONG_OPERATION;
        assertEquals(expected,consumer.processLine(toProcess));
    }

    @Test
    void testProcessFile_textWithCorrectOperation_transformedText() {
        String toProcess = "Hello#some_operation";

        StringOperation someOperation = mock(StringOperation.class);
        when(someOperation.operate("Hello")).thenReturn("HELLO");
        when(storage.getByName("some_operation")).thenReturn(someOperation);

        String expected = "HELLO";
        assertEquals(expected,consumer.processLine(toProcess));
    }
}