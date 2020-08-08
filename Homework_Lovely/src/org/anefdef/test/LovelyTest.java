package org.anefdef.test;

import org.anefdef.Lovely;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LovelyTest {

    Lovely lovely = new Lovely();

    @Test
    void testIsLovely_1201_true() {
        assertTrue(lovely.isLovely(1201));
    }

    @Test
    void testIsLovely_3301_true() {
        assertTrue(lovely.isLovely(3301));
    }

    @Test
    void testIsLovely_123456789_true() {
        assertTrue(lovely.isLovely(123456789));
    }

    @Test
    void testIsLovely_123123123_false() {
        assertFalse(lovely.isLovely(1234123123));
    }

    @Test
    void testIsLovely_1111_false() {
        assertFalse(lovely.isLovely(1111));
    }

    @Test
    void testIsLovely_111333_false() {
        assertFalse(lovely.isLovely(111333));
    }


}