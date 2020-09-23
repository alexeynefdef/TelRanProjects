package org.anefdef;

import java.util.*;

public class GraphUtils {

    //TODO: Get the way from start to finish as { List<Integer> getPath(ArrayList<List<Integer>> graph, int startID, int finishID) }
    // - int[] parents = new int[graph.size()]

    public int getShortestDistance(ArrayList<List<Integer>> graph, int startID, int finishID) {

        Deque<Integer> nodesQueue = new ArrayDeque<>();
        nodesQueue.addFirst(startID);

        int[] distances = new int[graph.size()];
        Arrays.fill(distances,-1);
        distances[startID] = 0;

        while(nodesQueue.size() > 0) {

            int currentNode = nodesQueue.removeLast();

            if (currentNode == finishID) {
                return distances[currentNode];
            }

            List<Integer> neighbours = graph.get(currentNode);

            for (int neighbour:neighbours) {
                if (distances[neighbour] == -1) {
                    nodesQueue.addFirst(neighbour);
                    distances[neighbour] = distances[currentNode] + 1;
                }
            }
        }
        return -1;
    }
}
