package org.anefdef.test;

import org.anefdef.task.OddSum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OddSumTest {

    OddSum limit = new OddSum();

    @Test
    public void testGetSumOfOddDigits_1and1_2() {
        assertEquals(1,limit.getSomOfOddDigits(1,2));
    }

    @Test
    public void testGetSumOfOddDigits_1and10_25() {
        assertEquals(25,limit.getSomOfOddDigits(1,10));
    }

    @Test
    public void testGetSumOfOddDigits_16and32_192() {
        assertEquals(192,limit.getSomOfOddDigits(16,32));
    }

    @Test
    public void testGetSumOfOddDigits_8and16_48() {
        assertEquals(48,limit.getSomOfOddDigits(8,16));
    }

    @Test
    public void testGetSumOfOddDigits_64and128_3072() {
        assertEquals(3072,limit.getSomOfOddDigits(64,128));
    }

    @Test
    public void testGetSumOfOddDigits_4and4_0() {
        assertEquals(0,limit.getSomOfOddDigits(4,4));
    }

    @Test
    public void testGetSumOfOddDigits_5and5_5() {
        assertEquals(5,limit.getSomOfOddDigits(5,5));
    }

}