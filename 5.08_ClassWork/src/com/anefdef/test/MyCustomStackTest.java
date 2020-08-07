package com.anefdef.test;

import com.anefdef.MyCustomStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCustomStackTest {

    MyCustomStack stack = new MyCustomStack();
    private Object CustomDequeEmptySourceException;

    @Test
    void testAddLast_emptyAndOne_1() {
        stack.addLast(1);
        assertEquals(1,stack.size());
    }

    @Test
    void testAddLast_OneAndTwo_2() {
        stack.addLast(1);
        stack.addLast(2);
        assertEquals(2,stack.size());
    }

    @Test
    void testAddLast_tenE_10() {
        int[] nums = {4, 2, 6, 1, 7, 19, 44, 102, 21, 0};
        for (int i : nums) {
            stack.addLast(i);
        }
        assertEquals(10, stack.size());
    }

    @Test
    void testRemoveLast_tenE_9() {
        int[] nums = {4,2,6,1,7,19,44,102,21,0};
        for (int i:nums) {
            stack.addLast(i);
        }
        stack.removeLast();
        assertEquals(9,stack.size());
        assertEquals(21,stack.getLast());
    }

    @Test
    void testRemoveLast_tenE_0() {
        int[] nums = {4,2,6,1,7,19,44,102,21,0};
        for (int i:nums) {
            stack.addLast(i); //10
        }
        for (int i = 0; i < nums.length; i++) {
            stack.removeLast();
        }
        assertEquals(0,stack.size());
    }

    @Test
    void testRemoveLast_one_1() {
        stack.addLast(1);
        assertEquals(1,stack.removeLast());
    }

    @Test
    void testGetMax_tenE_10() {
        int[] nums = {4, 2, 6, 1, 7, 19, 44, 102, 21, 0};
        for (int i : nums) {
            stack.addLast(i);
        }
        assertEquals(102, stack.getMax());
    }







}