package org.anefdef.test;

import org.anefdef.task.StreamCombination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class StreamCombinationTest {

    StreamCombination combination;

    @BeforeEach
    void init() {
        combination = new StreamCombination();
    }

    @Test
    void testCombine() {
        IntStream a = IntStream.range(1,11);
        IntStream b = IntStream.range(11,21);
        int[] expected = {6,9,10,12,15,18,20};
        int[] actual = combination.combine(a,b).sorted().toArray();

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i],actual[i]);
        }
    }

}