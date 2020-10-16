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