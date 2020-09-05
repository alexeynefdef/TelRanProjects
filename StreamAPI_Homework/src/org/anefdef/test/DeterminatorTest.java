package org.anefdef.test;

import org.anefdef.task.Determinator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeterminatorTest {

    Determinator determinator = new Determinator();

    @Test
    void testIsSimple_1_true() {
        assertTrue(determinator.isSimple(1));
    }

    @Test
    void testIsSimple_2_true() {
        assertTrue(determinator.isSimple(2));
    }

    @Test
    void testIsSimple_3_true() {
        assertTrue(determinator.isSimple(3));
    }

    @Test
    void testIsSimple_5_true() {
        assertTrue(determinator.isSimple(5));
    }

    @Test
    void testIsSimple_7_true() {
        assertTrue(determinator.isSimple(7));
    }

    @Test
    void testIsSimple_41_true() {
        assertTrue(determinator.isSimple(41));
    }

    @Test
    void testIsSimple_73_true() {
        assertTrue(determinator.isSimple(73));
    }

    @Test
    void testIsSimple_97_true() {
        assertTrue(determinator.isSimple(97));
    }

    @Test
    void testIsSimple_59_true() {
        assertTrue(determinator.isSimple(59));
    }

    @Test
    void testIsSimple_55_false() {
        assertTrue(determinator.isSimple(55));
    }

    @Test
    void testIsSimple_22_false() {
        assertTrue(determinator.isSimple(22));
    }

    @Test
    void testIsSimple_100_false() {
        assertTrue(determinator.isSimple(100));
    }
}