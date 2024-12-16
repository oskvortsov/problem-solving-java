package topic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/graph-valid-tree/description/
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) adj.put(i, new ArrayList<>());
        for (int[] pair: edges) {
            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        }

        return !dfs(adj, 0, -1, visited) && visited.size() == n;
    }

    boolean dfs(HashMap<Integer, List<Integer>> adj, int v, int par, HashSet<Integer> visited) {
        visited.add(v);

        for (int u: adj.get(v)) {
            if (u == par) continue;
            if (visited.contains(u) || dfs(adj, u, v, visited)) {
                return true;
            }
        }

        return false;
    }
}
