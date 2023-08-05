package topic.graph;

import java.util.HashMap;

// https://leetcode.com/problems/longest-cycle-in-a-graph/description/
public class LongestCycleInAGraph {
    public int longestCycle(int[] edges) {
        boolean[] visited = new boolean[edges.length];
        int max = -1;

        for (int i = 0; i < edges.length; i++) {
            max = Math.max(max, dfs(edges, visited, i));
        }


        return max;
    }

    int dfs(int[] edges, boolean[] visited, int root) {
        HashMap<Integer, Integer> dist = new HashMap<>();
        int count = 0;

        while (root != -1 && !visited[root]) {
            dist.put(root, count);
            visited[root] = true;
            root = edges[root];
            count++;
        }

        if (root != -1 && dist.containsKey(root)) {
            return count - dist.get(root);
        }

        return -1;
    }

}
