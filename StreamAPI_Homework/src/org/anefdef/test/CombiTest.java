package org.anefdef.test;

import org.anefdef.task.Combi;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class CombiTest {

    Combi combi = new Combi();

    @Test
    void testCombine_3Predicates_combinedOne() {

        Predicate<Integer> p1 = x -> x != 0;
        Predicate<Integer> p2 = x -> x % 2 == 0;
        Predicate<Integer> p3 = x -> x < 128;
        List<Predicate<Integer>> input = new ArrayList<>(Arrays.asList(p1,p2,p3));

        Predicate<Integer> expected = p1.and(p2).and(p3);
        boolean toTest = expected.test(6) && combi.combine(input).test(6);
        assertTrue(toTest);
    }

}