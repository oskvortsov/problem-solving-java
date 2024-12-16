package topic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class NumberOfConnectedComponentsInUnGraph {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < n; i++) adj.put(i, new ArrayList<>());
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(adj, visited, i, -1);
                answer++;
            }
        }

        return answer;
    }

    void dfs(HashMap<Integer, List<Integer>> adj, HashSet<Integer> visited, int v, int par) {
        visited.add(v);

        for (int u : adj.get(v)) {
            if (u == par) continue;
            if (!visited.contains(u)) {
                dfs(adj, visited, u, v);
            }
        }
    }
}
