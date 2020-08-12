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
        assertEquals(0,comparator.compare(a,b));
    }

    @Test
    void testPoint2DComparator_0and0_zero() {
        a = new Point2D(0,0);
        b = new Point2D(0,0);
        assertEquals(0,comparator.compare(a,b));
    }

    @Test
    void testPoint2DComparator_0and0point001_negative() {
        a = new Point2D(0,0);
        b = new Point2D(0,0.001);
        assertEquals(-1,comparator.compare(a,b));
    }

    @Test
    void testPoint2DComparator_0point001and0_positive() {
        a = new Point2D(0.001,0);
        b = new Point2D(0,0);
        assertEquals(1,comparator.compare(a,b));
    }

    @Test
    void testPoint2DComparator_0point001and0point001_zero() {
        a = new Point2D(0.001,0);
        b = new Point2D(0,0.001);
        assertEquals(0,comparator.compare(a,b));
    }

    @Test
    void testPoint2DComparator_aLessThanB_negative() {
        a = new Point2D(-3.5,7.4);
        b = new Point2D(4.8,15.18);
        assertEquals(-1,comparator.compare(a,b));
    }

    @Test
    void testPoint2DComparator_bLessThanA_positive() {
        b = new Point2D(-3.5,7.4);
        a = new Point2D(4.8,15.18);
        assertEquals(1,comparator.compare(a,b));
    }

    @Test
    void testPoint2DComparator_equalPoints_zero() {
        b = new Point2D(-3.5,7.4);
        a = new Point2D(-3.5,7.4);
        assertEquals(0,comparator.compare(a,b));
    }




}