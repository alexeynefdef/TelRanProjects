import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    MyLinkedList<Integer> list;
    MyLinkedList<Point2D> pointList;

    @BeforeEach
    void init() {
        pointList = new MyLinkedList<>();
        list = new MyLinkedList<>();
    }

    @Test
    void testSort_listOfInts_sortedList() {
        MyList<Integer> expected = new MyLinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        list.add(2);
        list.add(3);
        list.add(1);
        list.sort(null);

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i),list.get(i));
        }
        assertEquals(expected,list);
    }

    @Test
    void testSortWithComparator_Point2DList_sortedList() {

        MyList<Point2D> expected = new MyLinkedList<>();
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
        for (int i = 0; i < pointList.size()-1; i++) {
            assertEquals(expected.get(i),pointList.get(i));
        }
        assertEquals(expected,pointList);
    }

    @Test
    public void testSort_add16elt_9() {

        list.add(15);
        list.add(16);
        list.add(11);
        list.add(3);
        list.add(12);
        list.add(14);
        list.add(1);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(13);
        list.add(10);
        list.add(2);

        list.sort(null);
        assertEquals(9, list.get(8));
    }

    @Test
    public void testArrayIterator(){

        list.add(2);
        list.add(-1);
        list.add(23);
        list.add(4);
        list.add(89);

        MyList<Integer> afterIteration = new MyLinkedList<>();

        MyList<Integer> expected = new MyLinkedList<>();
        expected.add(2);
        expected.add(-1);
        expected.add(23);
        expected.add(4);
        expected.add(89);

        Iterator<Integer> it = list.iterator();
        if (it.hasNext()) {
            do {
                int num = it.next();
                afterIteration.add(num);
            } while (it.hasNext());
        }

        for (int i = 0; i < list.size(); i++) {
            assertEquals(expected.get(i),afterIteration.get(i));
        }
        assertEquals(expected,afterIteration);
    }

    @Test
    void testRemoveByElt_oneElList_False() {
        list.add(1);
        assertFalse(list.remove((Integer) 2));
    }

    @Test
    public void testRemoveByElt_addOneElt_true() {
        list.add(56);
        assertTrue(list.remove((Integer) 56));
    }

    @Test
    void testRemoveByElt_emptyList_Ex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove((Integer)10));
    }

    @Test
    void testRemoveIndex_oneE_size0() {
        list.add(1);
        assertEquals(1,list.remove(0));
        assertEquals(0,list.size());
    }

    @Test
    public void testRemoveByIndex_addOnePoint_true() {
        var exp = new Point2D(1,1);
        pointList.add(new Point2D(1,1));
        assertEquals(exp,pointList.remove(0));
    }

    @Test
    void testAdd_oneEl_size1_equalTo() {
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
    void testRemoveIndex_IndexOutOfBoundException2() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void testGet_IndexOutOfBoundException() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    void testGet_oneE_equalTo2() {
        list.add(88);
        assertEquals(88,list.get(0));
    }

    @Test
    void testGet_threeE_equalTo2() {
        list.add(88);
        list.add(17);
        list.add(910);
        assertEquals(910,list.get(2));
    }

    @Test
    void testGet_IndexOutOfBoundsException2() {
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
    public void testSize_emptyList_zero() {
        assertEquals(0, list.size());
    }

    @Test
    public void testAddEltAndSize_1elt_1() {
        list.add(6);
        assertEquals(1, list.size());
    }

    @Test
    public void testSize_add5elt_3() {
        list.add(5);
        list.add(5);
        list.add(5);

        assertEquals(3, list.size());
    }

    @Test
    void testGetElt_emptyListException_IndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void testSetAndGetElt_addOneElt_10() {
        list.add(9);
        list.set(0, 10);
        assertEquals(10, list.get(0));
    }

    @Test
    void testGetElt_add5Elt_7() {
        list.add(9);
        list.add(8);
        list.add(9);
        list.add(6);
        list.add(5);
        list.set(2, 7);
        assertEquals(7, list.get(2));
    }

    @Test
    void testContainsElt_add6Elt_true() {
        list.add(10);
        list.add(8);
        list.add(9);
        list.add(6);
        list.add(5);
        list.add(2);
        assertTrue(list.contains(9));
    }

    @Test
    void testContainsElt_add6Elt_false() {
        list.add(9);
        list.add(8);
        list.add(9);
        list.add(6);
        list.add(5);
        list.add(2);
        assertFalse(list.contains(1));
    }

    @Test
    void testRemoveEltByIndex_emptyListException_IndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void testRemoveEltByIndex_add6Elt_99() {
        list.add(99);
        list.add(87);
        list.add(9);
        list.add(66);
        list.add(99);
        list.add(20);
        assertEquals(99, list.remove(4));
    }

    @Test
    public void testRemoveByElt_addOneElt_false() {
        list.add(56);
        assertFalse(list.remove((Integer) 57));
    }

    @Test
    void testRemoveByElt_add6Elt_true() {
        list.add(99);
        list.add(87);
        list.add(9);
        list.add(66);
        list.add(99);
        list.add(20);
        assertTrue(list.remove((Integer) 66));
    }

    @Test
    void testRemoveByElt_add6Elt_false() {
        list.add(99);
        list.add(87);
        list.add(9);
        list.add(66);
        list.add(99);
        list.add(20);
        assertFalse(list.remove((Integer) 100));
    }


    @Test
    void testAdd_oneE_size1_equalTo() {
        list.add(5);
        assertEquals(5, list.get(0));
        assertEquals(1, list.size());
        assertTrue(list.contains(5));
    }

    @Test
    void testAdd_threeDifferentE_size3_equalTo2() {
        list.add(16);
        list.add(5);
        list.add(0);
        assertEquals(16, list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(0, list.get(2));
        assertEquals(3, list.size());
        assertTrue(list.contains(16));
        assertTrue(list.contains(5));
        assertTrue(list.contains(0));
        assertFalse(list.contains(100));
    }

    @Test
    void testAdd_1to100E_size100_equalTo2() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(100, list.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(i, list.get(i));
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(list.contains(i));
        }
    }


    @Test
    void testRemove16consistentNums_RemoveIndex15() {
        for (int i = 0; i < 16; i++) {
            list.add(i);
        }
        int res = list.remove(15);
        assertEquals(15, res);

    }

    @Test
    void testRemoveIndex_IndexOutOfBoundException() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }


    @Test
    void testAdd_onePoint_containsExistingPoint() {
        MyList<Point2D> pointList = new MyLinkedList<>();

        pointList.add(new Point2D(1,1));

        Point2D expected = new Point2D(1,1);
        assertTrue(pointList.contains(expected));
    }


    @Test
    void testGet_oneE_equalTo() {
        list.add(88);
        assertEquals(88, list.get(0));
    }

    @Test
    void testGet_threeE_equalTo() {
        list.add(88);
        list.add(17);
        list.add(910);
        assertEquals(910, list.get(2));
    }

    @Test
    void testGet_IndexOutOfBoundsException() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class,() -> list.get(1));
    }

}