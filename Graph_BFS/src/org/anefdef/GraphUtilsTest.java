package org.anefdef;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphUtilsTest {

    ArrayList<List<Integer>> graph;
    GraphUtils graphUtils;

    @BeforeEach
    void init() {

        List<List<Integer>> temp = new ArrayList<>(Arrays.asList(
                Collections.emptyList(),
                Arrays.asList(2,3),
                Arrays.asList(1,3),
                Arrays.asList(1,2,4),
                Arrays.asList(3,5),
                Collections.singletonList(4)
        ));
        graph = new ArrayList<>(temp);
        graphUtils = new GraphUtils();
    }

    @Test
    void getShortestDistance_smallGraph_startAndFinishEqual_0() {
        assertEquals(0,graphUtils.getShortestDistance(graph,0,0));
    }

    @Test
    void getShortestDistance_smallGraph_startAndFinishEqualNotSingle_0() {
        assertEquals(0,graphUtils.getShortestDistance(graph,3,3));
        assertEquals(0,graphUtils.getShortestDistance(graph,4,4));
    }

    @Test
    void getShortestDistance_smallGraph_startSingleAndFinishNot_minus1() {
        assertEquals(-1,graphUtils.getShortestDistance(graph,0,3));
    }

    @Test
    void getShortestDistance_smallGraph_startAndFinishConnected_1() {
        assertEquals(1,graphUtils.getShortestDistance(graph,1,3));
        assertEquals(1,graphUtils.getShortestDistance(graph,1,2));
        assertEquals(1,graphUtils.getShortestDistance(graph,2,3));
    }

    @Test
    void getShortestDistance_smallGraph_startAndFinishConnected_2() {
        assertEquals(2,graphUtils.getShortestDistance(graph,1,4));
        assertEquals(2,graphUtils.getShortestDistance(graph,2,4));
        assertEquals(2,graphUtils.getShortestDistance(graph,3,5));
        assertEquals(2,graphUtils.getShortestDistance(graph,4,1));
        assertEquals(2,graphUtils.getShortestDistance(graph,4,2));
        assertEquals(2,graphUtils.getShortestDistance(graph,5,3));
    }

    @Test
    void getShortestDistance_smallGraph_startAndFinishConnected_3() {
        assertEquals(3,graphUtils.getShortestDistance(graph,1,5));
        assertEquals(3,graphUtils.getShortestDistance(graph,2,5));
        assertEquals(3,graphUtils.getShortestDistance(graph,5,1));
        assertEquals(3,graphUtils.getShortestDistance(graph,5,2));
    }


}