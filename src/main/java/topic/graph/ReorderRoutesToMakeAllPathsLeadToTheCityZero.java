package topic.graph;

import java.util.*;

// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, Set<Integer>> biDirectRoads = new HashMap<>();
        HashMap<Integer, Set<Integer>> roads = new HashMap<>();

        for (int[] path: connections) {
            biDirectRoads.computeIfAbsent(path[0], i -> new HashSet<>()).add(path[1]);
            biDirectRoads.computeIfAbsent(path[1], i -> new HashSet<>()).add(path[0]);
            roads.computeIfAbsent(path[0], i -> new HashSet<>()).add(path[1]);
        }

        int res = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);

        while (!queue.isEmpty()) {
            int root = queue.poll();

            for (int to: biDirectRoads.get(root)) {
                if (visited[to]) {
                    continue;
                }

                if (!roads.containsKey(to) || !roads.get(to).contains(root)) {
                    res++;
                }

                queue.add(to);
            }

            visited[root] = true;
        }

        return res;
    }
}
