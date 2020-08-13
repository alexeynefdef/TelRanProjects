package org.anefdef.test;

import org.anefdef.Point2D;
import org.anefdef.Point2DComparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {

    Point2DComparator comparator = new Point2DComparator();
    Point2D a;
    Point2D b;

    @Test
    void testPoint2DComparator_1and1_zero() {
        a = new Point2D(1,1);
        b = new Point2D(1,1);
        assertTrue(a.compareTo(b) == 0);
    }

    @Test
    void testPoint2DComparator_0and0_zero() {
        a = new Point2D(0,0);
        b = new Point2D(0,0);
        assertTrue(a.compareTo(b) == 0);
    }

    @Test
    void testPoint2DComparator_0and0point001_negative() {
        a = new Point2D(0,0);
        b = new Point2D(0,0.001);
        assertTrue(a.compareTo(b) < 0);
    }

    @Test
    void testPoint2DComparator_0point001and0_positive() {
        a = new Point2D(0.001,0);
        b = new Point2D(0,0);
        assertTrue(a.compareTo(b) > 0);
    }

    @Test
    void testPoint2DComparator_0point001and0point001_zero() {
        a = new Point2D(0.001,0);
        b = new Point2D(0,0.001);
        assertTrue(a.compareTo(b) == 0);
    }

    @Test
    void testPoint2DComparator_aLessThanB_negative() {
        a = new Point2D(-3.5,7.4);
        b = new Point2D(4.8,15.18);
        assertTrue(a.compareTo(b) < 0);
    }

    @Test
    void testPoint2DComparator_bLessThanA_positive() {
        a = new Point2D(4.8,15.18);
        b = new Point2D(-3.5,7.4);
        assertTrue(a.compareTo(b) > 0);
    }

    @Test
    void testPoint2DComparator_equalPoints_zero() {
        a = new Point2D(-3.5,7.4);
        b = new Point2D(-3.5,7.4);
        assertTrue(a.compareTo(b) == 0);

    }

    @Test
    void testPoint2DEquals_equalPoints_true() {
        a = new Point2D(-3.5,7.4);
        b = new Point2D(-3.5,7.4);
        assertEquals(a,b);
    }

    @Test
    void testPoint2DEquals_notEqualPoints_false() {
        a = new Point2D(-3.5,7.41);
        b = new Point2D(-3.5,7.4);
        assertNotEquals(a,b);
    }





}