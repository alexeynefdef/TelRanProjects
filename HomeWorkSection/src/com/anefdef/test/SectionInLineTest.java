package com.anefdef.test;

import com.anefdef.SectionInLine;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SectionInLineTest {

    SectionInLine section = new SectionInLine();

    @Test
    void testFindMaxSection_listAnd03_() {
        Double[] doubles = {0.100,0.150,0.170,0.200,0.310,1.000,1.200,1.230,1.350,1.500,2.000};
        List<Double> numbers = new ArrayList<>(Arrays.asList(doubles));
        Deque<Double> expected = new ArrayDeque<>(Arrays.asList());
        assertEquals(5,section.findMaxSection(numbers,0.300));
    }

    @Test
    void testFindMaxSection_LinkedListAnd03_() {
        Double[] doubles = {0.100,0.150,0.170,0.200,0.310,1.000,1.200,1.230,1.350,1.500,2.0};
        List<Double> numbers = new LinkedList<>(Arrays.asList(doubles));
        Deque<Double> expected = new ArrayDeque<>(Arrays.asList());
        assertEquals(5,section.findMaxSection(numbers,0.300));
    }
}