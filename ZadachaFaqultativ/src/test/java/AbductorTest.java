import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AbductorTest {

    Abductor abductor = new Abductor();

    @Test
    void testDoStuff_1_1() {
        Set<Integer> expected = new HashSet<>(Collections.singletonList(1));
        assertEquals(expected,abductor.doStuff(1));
    }

    @Test
    void testDoStuff_2_2() {
        Set<Integer> expected = new HashSet<>(Collections.singletonList(2));
        assertEquals(expected,abductor.doStuff(2));
    }

    @Test
    void testDoStuff_3_2and1() {
        Set<Integer> expected = new HashSet<>(Arrays.asList(2,1));
        assertEquals(expected,abductor.doStuff(3));
    }

    @Test
    void testDoStuff_6_123() {
        Set<Integer> expected = new HashSet<>(Arrays.asList(1,2,3));
        assertEquals(expected,abductor.doStuff(6));
    }


    @Test
    void testDoStuff_9_126() {
        Set<Integer> expected = new HashSet<>(Arrays.asList(1,2,6));
        assertEquals(expected,abductor.doStuff(9));
    }


    @Test
    void testDoStuff_12_1236() {
        Set<Integer> expected = new HashSet<>(Arrays.asList(1,2,3,6));
        Set<Integer> expected2 = new HashSet<>(Arrays.asList(1,2,4,5));
        boolean b = expected.equals(abductor.doStuff(12)) || expected2.equals(abductor.doStuff(12));
        assertTrue(b);
    }
}