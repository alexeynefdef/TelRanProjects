package com.anefdef.test;

import com.anefdef.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayDequeTest {

    MyArrayDeque<Integer> deque = new MyArrayDeque<>(10);

    @Test
    void testAddLast_empty_1() {
        deque.addLast(1);
        assertEquals(1,deque.size());
        assertEquals(1,deque.getLast());
    }

    @Test
    void testSize_newInstance_0() {
        assertEquals(0,deque.size());
    }

    @Test
    void testAddLast_addLast3E_3() {
        deque.addLast(5);
        deque.addLast(2);
        deque.addLast(7);
        assertEquals(3,deque.size());
    }

    @Test
    void tesAddFirst_addFirst2E_2() {
        deque.addFirst(5);
        deque.addFirst(2);
        assertEquals(2,deque.size());
    }

    @Test
    void testAddFirstLast_addFirst2EAndAddLast1E_3() {
        deque.addFirst(2);
        deque.addFirst(1);
        deque.addLast(5);
        assertEquals(3,deque.size());
    }

    @Test
    void testAddLast_add1E_getLast() {
        deque.addLast(5);
        assertEquals(5,deque.getLast());
    }

    @Test
    void testAddLast_add2E_getLast() {
        deque.addLast(5);
        deque.addLast(7);
        assertEquals(7,deque.getLast());
    }

    @Test
    void testAddLast_add3E_getLast() {
        deque.addLast(5);
        deque.addLast(7);
        deque.addLast(10);
        assertEquals(10,deque.getLast());
    }

    @Test
    void testAddFirst_add1E_getFirst() {
        deque.addFirst(5);
        assertEquals(5,deque.getFirst());
    }

    @Test
    void testAddFirst_add2E_getFirst() {
        deque.addFirst(5);
        deque.addFirst(7);
        assertEquals(7,deque.getFirst());
    }

    @Test
    void testAddFirst_add3E_getFirst() {
        deque.addFirst(5);
        deque.addFirst(7);
        deque.addFirst(10);
        assertEquals(10,deque.getFirst());
    }

    @Test
    void testAddLast1E_getFirstGetLast() {
        deque.addLast(3);
        assertEquals(3,deque.getFirst());
        assertEquals(3,deque.getLast());
    }

    @Test
    void testAddFirst2E_getFirstGetLast() {
        deque.addFirst(3);
        deque.addFirst(8);
        assertEquals(8,deque.getFirst());
        assertEquals(3,deque.getLast());
    }

    @Test
    void testAddFirst5E_getFirstGetLast() {
        deque.addFirst(3);
        deque.addFirst(8);
        deque.addFirst(4);
        deque.addLast(0);
        deque.addLast(-9);
        assertEquals(4,deque.getFirst());
        assertEquals(-9,deque.getLast());
        assertEquals(5,deque.size());
    }


    @Test
    void testRemoveLast_addFirst1eAndRemove_size0() {
        deque.addFirst(3);
        assertEquals(3,deque.removeLast());
        assertEquals(0,deque.size());
    }

    @Test
    void testRemoveFirst_addLast1eAndRemove_size0() {
        deque.addLast(3);
        assertEquals(3,deque.removeFirst());
        assertEquals(0,deque.size());
    }

    @Test
    void testRemoveFirst_addFirst1eAndRemove_size0() {
        deque.addFirst(3);
        assertEquals(3,deque.removeFirst());
        assertEquals(0,deque.size());
    }

    @Test
    void testRemoveLast_addLast1eAndRemove_size0() {
        deque.addLast(3);
        assertEquals(3,deque.removeLast());
        assertEquals(0,deque.size());
    }

    @Test
    void testAddRemoveMix_severalEltsAdded_removeSeveralElts() {
        deque.addLast(3);
        deque.addFirst(8);
        assertEquals(3,deque.removeLast());
        deque.addFirst(-5);
        deque.addFirst(-2);
        deque.addFirst(7);
        deque.addLast(10);
        assertEquals(7,deque.removeFirst());
        deque.addLast(13);
        assertEquals(5,deque.size());
    }

    @Test
    void testRemoveFirst_fromEmptyDeque_throwsException() {
        assertThrows(MyDequeEmptyException.class, () -> deque.removeFirst());
    }

    @Test
    void testRemoveLast_fromEmptyDeque_throwsException() {
        assertThrows(MyDequeEmptyException.class, () -> deque.removeLast());
    }

    @Test
    void testAddFirst_overflowArray_throwsException() {
        for (int i = 0; i < 10; i++) {
            deque.addFirst(12);
        }
        assertThrows(MyDequeOverflowException.class, () -> deque.addFirst(1));
    }

    @Test
    void testAddLast_overflowArray_throwsException() {
        for (int i = 0; i < 10; i++) {
            deque.addLast(12);
        }
        assertThrows(MyDequeOverflowException.class, () -> deque.addLast(1));
    }

    @Test
    void testReversedIterator() {
        deque = new MyArrayDeque<>(2);
        deque.addLast(3);
        deque.addFirst(8);

        Iterator<Integer> it = new ReversedMyArrayDequeIterator<>(deque);

        List<Integer> res = new ArrayList<>();
        while(it.hasNext()) {
            int current = it.next();
            res.add(current);
        }

        List<Integer> expected = Arrays.asList(3,8);
        assertEquals(expected,res);
    }

    @Test
    void testDefaultIterator() {
        deque = new MyArrayDeque<>(2);
        deque.addLast(3);
        deque.addFirst(8);

        Iterator<Integer> it = deque.iterator();

        List<Integer> res = new ArrayList<>();
        while(it.hasNext()) {
            int current = it.next();
            res.add(current);
        }

        List<Integer> expected = Arrays.asList(8,3);
        assertEquals(expected,res);
    }


}