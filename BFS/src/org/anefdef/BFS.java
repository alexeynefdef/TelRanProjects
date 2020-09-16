package org.anefdef;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BFS {

    public List<Integer> leftToRight(Node root) {
        List<Integer> result = new ArrayList<>();
        ArrayDeque<Node> temp = new ArrayDeque<>();

        temp.addFirst(root);

        while (!temp.isEmpty()) {
            Node last = temp.removeLast();
            if (last.getLeft() != null)
                temp.addFirst(last.getLeft());
            if (last.getRight() != null)
                temp.addFirst(last.getRight());
            result.add(last.getValue());
        }
        return result;
    }
}
