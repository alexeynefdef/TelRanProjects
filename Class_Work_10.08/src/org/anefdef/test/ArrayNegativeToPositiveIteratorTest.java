package org.anefdef.test;

import org.anefdef.ArrayNegativeToPositiveIterator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayNegativeToPositiveIteratorTest {
    int[] arrayToIterate = {10,-3,5,-5,0,7,-1,4};

    @Test
    void testIterator_mixArr_correctOrder() {
        List<Integer> expected = Arrays.asList(-3,-5,-1,10,5,0,7,4);
        List<Integer> afterIteration = new ArrayList<>();
        ArrayNegativeToPositiveIterator it = new ArrayNegativeToPositiveIterator(arrayToIterate);

        while (it.hasNext()) {
            int num = it.next();
            afterIteration.add(num);
        }
        assertEquals(expected,afterIteration);
    }
}