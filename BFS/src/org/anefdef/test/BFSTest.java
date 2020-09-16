package org.anefdef.test;

import org.anefdef.BFS;
import org.anefdef.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    BFS bfs;

    @BeforeEach
    void init() {
        bfs = new BFS();
    }

    @Test
    void testLefToRight_SingleNode_1eList() {
        Node root = new Node(null,null,8);
        assertEquals(List.of(8),bfs.leftToRight(root));
    }

    @Test
    void testLefToRight_3Nodes_3eList() {
        Node left = new Node(null,null,5);
        Node right = new Node(null,null,11);
        Node root = new Node(left,right,8);

        assertEquals(List.of(8,5,11),bfs.leftToRight(root));
    }

    @Test
    void testLefToRight_5Nodes_5eList() {
        var leftL = new Node(null,null,13);
        var leftR = new Node(null,null,1);
        var rightR = new Node(null,null,2);
        var left = new Node(leftL,null,5);
        var right = new Node(leftR,rightR,11);

        var root = new Node(left,right,8);

        assertEquals(List.of(8,5,11,13,1,2),bfs.leftToRight(root));
    }
}