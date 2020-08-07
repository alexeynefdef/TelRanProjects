import anefdef.MultiFinder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultiFinderTest {

    MultiFinder mf = new MultiFinder();
    List<Integer> input = new ArrayList<>(Arrays.asList(2,3,6,7,7,10,12,17));

    @Test
    void testIsMultiplied_listAnd64_false() {
        var list = new ArrayList<Integer>(Arrays.asList(2,3,4,5,6,7,8));
        assertFalse(mf.isMultiplied(list,64));
    }

    @Test
    void testIsMultiplied_listAnd61_false() {
        assertFalse(mf.isMultiplied(input,61));
    }

   @Test
    void testIsMultiplied_listAnd10_false() {
        assertFalse(mf.isMultiplied(input,10));
    }

    @Test
    void testIsMultiplied_emptyAndOne_false() {
        List<Integer> emptyList = new ArrayList<>();
        assertFalse(mf.isMultiplied(emptyList,1));
    }

    @Test
    void testIsMultiplied_list70_true() {
        assertTrue(mf.isMultiplied(input,70));
    }

    @Test
    void testIsMultiplied_listAnd20_true() {
        assertTrue(mf.isMultiplied(input,20));
    }

    @Test
    void testIsMultiplied_listAnd30_true() {
        assertTrue(mf.isMultiplied(input,30));
    }




}