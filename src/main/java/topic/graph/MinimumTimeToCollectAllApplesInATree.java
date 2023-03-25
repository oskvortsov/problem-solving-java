package topic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
public class MinimumTimeToCollectAllApplesInATree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, List<Integer>> treeMap = new HashMap<>();

        for (int[] path: edges) {
            int parent = path[0], child = path[1];
            treeMap.computeIfAbsent(parent, i -> new ArrayList<>()).add(child);
        }

        return dfs(treeMap, 0, 0, hasApple);

    }

    private int dfs(HashMap<Integer, List<Integer>> map, int cur, int step, List<Boolean> hasApple) {
        List<Integer> children = map.get(cur);
        int childrenStep = 0;

        if (children != null) {
            for (int child: children) {
                childrenStep += dfs(map, child, 0, hasApple);
            }
        }

        if (hasApple.get(cur) || childrenStep != 0) {
            step += 2 + childrenStep;
        }

        return step;
    }
}
