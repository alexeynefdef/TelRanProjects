package org.anefdef.test;

import org.anefdef.MaxEltStack;
import org.anefdef.Point2D;
import org.anefdef.exception.CustomStackEmptySourceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MaxEltStackTest {

    MaxEltStack<Integer> stack;
    MaxEltStack<Point2D> pointStack;

    @BeforeEach
    public void init() {
        stack = new MaxEltStack<>();
        pointStack = new MaxEltStack<>();
    }

    @Test
    void testGetMaxUsingPoint2D_SeveralPoints_Point45point14and3point14() {
        Point2D expected = new Point2D(45.14, 3.14);
        pointStack.addLast(new Point2D(0.13, 4.2));
        pointStack.addLast(new Point2D(45.14, 3.14));
        pointStack.addLast(new Point2D(5.44, 31.33));
        pointStack.addLast(new Point2D(0.0001, 3.033));
        assertEquals(expected, pointStack.getMax());
    }

    @Test
    void testGetMaxUsingPoint2D_EqualPoints_pointZeroZero() {
        Point2D expected = new Point2D(0, 0);
        pointStack.addLast(new Point2D(0, 0));
        pointStack.addLast(new Point2D(0, 0));
        pointStack.addLast(new Point2D(0, 0));
        pointStack.addLast(new Point2D(0, 0));
        pointStack.addLast(new Point2D(0, 0));
        assertEquals(expected, pointStack.getMax());
    }

    @Test
    void testGetMaxUsingPoint2D_notEqualPoints_pointZeroAndZeroZeroOne() {
        Point2D expected = new Point2D(0, 0.001);
        pointStack.addLast(new Point2D(0, 0));
        pointStack.addLast(new Point2D(0, 0));
        pointStack.addLast(new Point2D(0, 0));
        pointStack.addLast(new Point2D(0, 0.001));
        pointStack.addLast(new Point2D(0, 0));
        assertEquals(expected, pointStack.getMax());
    }


    @Test
    void testAddLast_emptyAndOne_1() {
        stack.addLast(1);
        assertEquals(1, stack.size());
    }

    @Test
    void testAddLast_OneAndTwo_2() {
        stack.addLast(1);
        stack.addLast(2);
        assertEquals(2, stack.size());
    }

    @Test
    void testAddLast_addLast3E_3() {
        stack.addLast(5);
        stack.addLast(2);
        stack.addLast(7);
        assertEquals(3, stack.size());
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
        int[] nums = {4, 2, 6, 1, 7, 19, 44, 102, 21, 0};
        for (int i : nums) {
            stack.addLast(i);
        }
        stack.removeLast();
        assertEquals(9, stack.size());
        assertEquals(21, stack.getLast());
    }

    @Test
    void testRemoveLast_tenE_0() {
        int[] nums = {4, 2, 6, 1, 7, 19, 44, 102, 21, 0};
        for (int i : nums) {
            stack.addLast(i); //10
        }
        while (stack.size() > 0) {
            stack.removeLast();
        }
        assertEquals(0, stack.size());
    }

    @Test
    void testRemoveLast_one_1() {
        stack.addLast(1);
        assertEquals(1, stack.removeLast());
    }

    @Test
    void testGetMax_tenE_10() {
        int[] numbers = {4, 2, 6, 1, 7, 19, 44, 102, 21, 0};
        for (int i : numbers) {
            stack.addLast(i);
        }
        assertEquals(102, stack.getMax());
    }

    @Test
    void testSize_newInstance_0() {
        assertEquals(0, stack.size());
    }


    @Test
    void testAddFirst_getLast() {
        stack.addLast(5);
        assertEquals(5, stack.getLast());
    }

    @Test
    void testAddLast_getLast() {
        stack.addLast(5);
        stack.addLast(7);
        assertEquals(7, stack.getLast());
    }

    @Test
    void testAddLast_add3E_getLast() {
        stack.addLast(5);
        stack.addLast(7);
        stack.addLast(10);
        assertEquals(10, stack.getLast());
    }

    @Test
    void testRemoveLast_AndRemoveLast_size0() {
        stack.addLast(3);
        assertEquals(3, stack.removeLast());
        assertEquals(0, stack.size());
    }

    @Test
    void testRemoveFirst_fromEmptyDeque_throwsException() {
        assertThrows(CustomStackEmptySourceException.class, () -> stack.removeLast());
    }

    @Test
    void testAddRemoveMix_severalEltsAdded_removeSeveralElts() {
        stack.addLast(3);
        stack.addLast(8);
        assertEquals(8, stack.removeLast());
        stack.addLast(-5);
        stack.addLast(-2);
        stack.addLast(7);
        stack.addLast(10);
        assertEquals(10, stack.removeLast());
        stack.addLast(13);
        assertEquals(5, stack.size());
    }
}