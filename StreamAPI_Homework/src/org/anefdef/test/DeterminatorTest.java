package org.anefdef.test;

import org.anefdef.task.Determinator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeterminatorTest {

    Determinator determinator = new Determinator();

    @Test
    void testIsSimple_101_true() {
        assertTrue(determinator.isPrime(101));
    }

    @Test
    void testIsSimple_2_true() {
        assertTrue(determinator.isPrime(2));
    }

    @Test
    void testIsSimple_3_true() {
        assertTrue(determinator.isPrime(3));
    }

    @Test
    void testIsSimple_5_true() {
        assertTrue(determinator.isPrime(5));
    }

    @Test
    void testIsSimple_7_true() {
        assertTrue(determinator.isPrime(7));
    }

    @Test
    void testIsSimple_41_true() {
        assertTrue(determinator.isPrime(41));
    }

    @Test
    void testIsSimple_73_true() {
        assertTrue(determinator.isPrime(73));
    }

    @Test
    void testIsSimple_97_true() {
        assertTrue(determinator.isPrime(97));
    }

    @Test
    void testIsSimple_59_true() {
        assertTrue(determinator.isPrime(59));
    }

    @Test
    void testIsSimple_55_false() {
        assertFalse(determinator.isPrime(55));
    }

    @Test
    void testIsSimple_22_false() {
        assertFalse(determinator.isPrime(22));
    }

    @Test
    void testIsSimple_100_false() {
        assertFalse(determinator.isPrime(100));
    }
}