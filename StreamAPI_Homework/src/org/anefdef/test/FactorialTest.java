package org.anefdef.test;

import org.anefdef.task.Factorial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    Factorial faq = new Factorial();

    @Test
    void testGetF2_2() {
        assertEquals(2,faq.getF(2));
    }

    @Test
    void testGetF3_6() {
        assertEquals(2,faq.getF(2));
    }

    @Test
    void testGetF4_24() {
        assertEquals(2,faq.getF(2));
    }

    @Test
    void testGetF5_120() {
        assertEquals(2,faq.getF(2));
    }

    @Test
    void testGetF6_720() {
        assertEquals(2,faq.getF(2));
    }


}