package org.anefdef;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    Task task;

    @BeforeEach
    void init() {
        task = new Task();
    }

    // 21 OCT

    @Test
    void testFindSquares_3_9_2() {
        assertEquals(2,task.findSquares(3,9));
    }

    @Test
    void testFindSquares_3_18_3() {
        assertEquals(3,task.findSquares(3,18));
    }

    @Test
    void testFindSquares_5_25_3() {
        assertEquals(3,task.findSquares(5,25));
    }

    @Test
    void testFindSquares_1_100_10() {
        assertEquals(10,task.findSquares(1,100));
    }

    @Test
    void testFindDigits_1_1_0() {
        assertEquals(0,task.findDigits(1,1));
    }

    @Test
    void testFindDigits_3_9_1() {
        assertEquals(1,task.findDigits(3,9));
    }

    @Test
    void testFindDigits_3_18_2() {
        assertEquals(2,task.findDigits(3,18));
    }

    @Test
    void testFindDigits_5_25_3() {
        assertEquals(3,task.findDigits(5,25));
    }

    @Test
    void testFindDigits_1_100_9() {
        assertEquals(9,task.findDigits(1,100));
    }









    // 14 OCT

    @Test
    void testDoStuff_153_162() {
        assertEquals(162,task.doStuff(153));
    }

    @Test
    void testDoStuff_1_10() {
        assertEquals(10,task.doStuff(1));
    }

    @Test
    void testDoStuff_286_295() {
        assertEquals(295,task.doStuff(286));
    }

    @Test
    void testDoStuff_99999_() {
        assertEquals(189999,task.doStuff(99999));
    }

    @Test
    void testDoThings_oneMatch_1() {
        int[] A = {5,0,2,3};
        int[] B = {3,2,1,4};
        assertEquals(1, task.doThings(A,B));
    }

    @Test
    void testDoThings_equalArrays_twoMatch_2() {
        int[] A = {5,0,2,3};
        int[] B = {5,0,2,3};
        assertEquals(2, task.doThings(A,B));
    }

    @Test
    void testDoThings_equalArraysEqualDigits_oneMatch_1() {
        int[] A = {5,5,5,5};
        int[] B = {5,5,5,5};
        assertEquals(1, task.doThings(A,B));
    }

    @Test
    void testDoThings_mixedArrays_oneMatch_1() {
        int[] A = {3,1,4,0};
        int[] B = {2,2,-1,5};
        assertEquals(1, task.doThings(A,B));
    }

    @Test
    void testDoThings_noMatch_0() {
        int[] A = {5,7,5,4};
        int[] B = {3,2,1,4};
        assertEquals(0, task.doThings(A,B));
    }

    @Test
    void testDoThings_4Match_4() {
        int[] A = {0,0,0,0,0};
        int[] B = {0,0,0,0,0};
        assertEquals(4, task.doThings(A,B));
    }






}