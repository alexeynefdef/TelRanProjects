package com.anefdef.test;

import com.anefdef.CoveredPointsFinder;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CoveredPointsFinderTest {

    CoveredPointsFinder finder = new CoveredPointsFinder();

    @Test
    void testFindMaxSection_noPoints_zero() {
        List<Double> points = Collections.EMPTY_LIST;
        assertEquals(0,finder.findMaxSection(points,1));
    }
}