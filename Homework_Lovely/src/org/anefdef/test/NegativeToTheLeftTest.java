package org.anefdef.test;

import org.anefdef.NegativeToTheLeft;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NegativeToTheLeftTest {

    NegativeToTheLeft negative = new NegativeToTheLeft();
    @Test
    void testToTheLeft_emptyList_null() {
        assertEquals(null,negative.toTheLeft(Collections.EMPTY_LIST));
    }

    @Test
    void testToTheLeft_mixList_editedList() {
        List<Integer> input = new ArrayList<>(Arrays.asList(2,-1,6,1,-4,0,15,834,55,-99));
        List<Integer> expected = new ArrayList<>(Arrays.asList(-1,-4,-99,2,6,1,0,15,834,55));
        assertEquals(expected,negative.toTheLeft(input));
    }

    @Test
    void testToTheLeft_mixLinkedList_editedList() {
        List<Integer> input = new LinkedList<>(Arrays.asList(2,-1,6,1,-4,0,15,834,55,-99));
        List<Integer> expected = new ArrayList<>(Arrays.asList(-1,-4,-99,2,6,1,0,15,834,55));
        assertEquals(expected,negative.toTheLeft(input));
    }

    @Test
    void testToTheLeft_m1and0duplicatesList_editedList() {
        List<Integer> input = new ArrayList<>(Arrays.asList(-1,0,-1,0,0,0,-1,-1,0,-1));
        List<Integer> expected = new ArrayList<>(Arrays.asList(-1,-1,-1,-1,-1,0,0,0,0,0));
        assertEquals(expected,negative.toTheLeft(input));
    }

    @Test
    void testToTheLeft_m1duplicatesList_editedList() {
        List<Integer> input = new ArrayList<>(Arrays.asList(-1,-1,-1,-1,-1));
        List<Integer> expected = new ArrayList<>(Arrays.asList(-1,-1,-1,-1,-1));
        assertEquals(expected,negative.toTheLeft(input));
    }

    @Test
    void testToTheLeft_0duplicatesList_editedList() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        List<Integer> expected = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        assertEquals(expected,negative.toTheLeft(input));
    }





}