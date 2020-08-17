package org.anefdef.test;

import org.anefdef.MyArrayList;
import org.anefdef.MyList;
import org.anefdef.Point2D;
import org.anefdef.Point2DComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    MyList<Integer> list;
    MyList<Point2D> pointList;

    @BeforeEach
    void init() {
        pointList = new MyArrayList<>();
        list = new MyArrayList<>();
    }

    @Test
    void testAdd_oneE_size1_equalTo() {
        list.add(5);
        assertEquals(5,list.get(0));
        assertEquals(1,list.size());
        assertTrue(list.contains(5));
    }

    @Test
    void testAdd_threeDifferentE_size3_equalTo() {
        list.add(16);
        list.add(5);
        list.add(0);
        assertEquals(16,list.get(0));
        assertEquals(5,list.get(1));
        assertEquals(0,list.get(2));
        assertEquals(3,list.size());
        assertTrue(list.contains(16));
        assertTrue(list.contains(5));
        assertTrue(list.contains(0));
        assertFalse(list.contains(100));
    }

    @Test
    void testAdd_1to100E_size100_equalTo() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(100,list.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(i,list.get(i));
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(list.contains(i));
        }
    }

    @Test
    void testRemoveIndex_oneE_size0() {
        list.add(1);
        assertEquals(1,list.remove(0));
        assertEquals(0,list.size());
    }

    @Test
    void testRemoveIndex_threeDifferentElRemoveOne_size2_equalTo() {
        list.add(16);
        list.add(5);
        list.add(671);
        assertEquals(671,list.remove(2));
        assertEquals(2,list.size());
        assertFalse(list.contains(671));
    }

    @Test
    void testRemoveIndex_100DifferentElRemove100_size0() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0, j = 99; i < 99; i++, j--) {
            assertEquals(i,list.remove(0));
            assertEquals(j,list.size());
        }
    }

    @Test
    void testRemove16E_RemoveIndex15() {
        for (int i = 0; i < 16; i++) {
            list.add(i);
        }
        int res = list.remove(15);
        assertEquals(15,res);

    }

    @Test
    void testRemoveIndex_IndexOutOfBoundException() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void testGet_IndexOutOfBoundException() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    void testGet_oneE_equalTo() {
        list.add(88);
        assertEquals(88,list.get(0));
    }

    @Test
    void testGet_threeE_equalTo() {
        list.add(88);
        list.add(17);
        list.add(910);
        assertEquals(910,list.get(2));
    }

    @Test
    void testGet_IndexOutOfBoundsException() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class,() -> list.get(1));
    }

    @Test
    void testAdd_twoPoints_containsExistingPoint() {
        pointList.add(new Point2D(1,1));
        Point2D expected = new Point2D(1,1);
        assertTrue(pointList.contains(expected));
    }

    @Test
    void testSort_listOfInts_sortedList() {
        MyList<Integer> expected = new MyArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        list.add(2);
        list.add(3);
        list.add(1);
        list.sort();
        for (int i = 1; i < list.size(); i++) {
            assertEquals(list.get(i),expected.get(i));
        }
    }

    @Test
    void testForEach_list_getElement() {
        list.add(1);
        list.add(2);
        list.add(3);
        int count = 1;
        for (int i:list) {
            assertEquals(i,count++);
        }
    }

    @Test
    void testIterator_list_getElement() {
        Point2D expected = new Point2D(0,1);
        pointList.add(new Point2D(0,1));
        pointList.add(new Point2D(0,1));
        pointList.add(new Point2D(0,1));
        for (Point2D point2D:pointList) {
            assertEquals(expected,point2D);
        }
    }

    @Test
    void testSortWithComparator_Point2DList_sortedList() {
        MyList<Point2D> expected = new MyArrayList<>();
        expected.add(new Point2D(0,1));
        expected.add(new Point2D(1,1));
        expected.add(new Point2D(4,4));
        expected.add(new Point2D(3,7));
        expected.add(new Point2D(16,3));

        pointList.add(new Point2D(4,4));
        pointList.add(new Point2D(1,1));
        pointList.add(new Point2D(0,1));
        pointList.add(new Point2D(16,3));
        pointList.add(new Point2D(3,7));

        pointList.sort(new Point2DComparator());
        for (int i = 0; i < pointList.size(); i++) {
            assertEquals(expected.get(i),pointList.get(i));
        }
    }



}






















