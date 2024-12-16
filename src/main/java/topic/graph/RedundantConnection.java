package topic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/redundant-connection/description/
public class RedundantConnection {
    private class UF {
        int[] index;
        int[] weights;

        UF(int size) {
            index = new int[size + 1];
            weights = new int[size + 1];

            for (int i = 0; i <= size; i++) {
                index[i] = i;
                weights[i] = 1;
            }
        }

        int find(int x) {
            if (index[x] == x) {
                return x;
            }

            return index[x] = find(index[x]);
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return;
            }

            if (weights[rootA] > weights[rootB]) {
                index[rootB] = rootA;
            } else if (weights[rootA] < weights[rootB]) {
                index[rootA] = rootB;
            } else {
                index[rootB] = rootA;
                weights[rootA]++;
            }
        }

        boolean isUnion(int a, int b) {
            return find(a) == find(b);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = 0;
        for (int[] edge: edges) n = Math.max(Math.max(edge[0], edge[1]), n);
        int[] result = new int[2];

        UF uf = new UF(n);
        for (int[] edge: edges) {
            if (uf.isUnion(edge[0], edge[1])) {
                result = edge;
                continue;
            }

            uf.union(edge[0], edge[1]);
        }

        return result;
    }
}
//    public int[] findRedundantConnection(int[][] edges) {
//        HashMap<Integer, List<Integer>> adj = new HashMap<>();
//        HashSet<Integer> visited = new HashSet<>();
//        List<int[]> result = new ArrayList<>();
//        int n = 0;
//
//        for (int[] vertex : edges) {
//            if (!adj.containsKey(vertex[0])) adj.put(vertex[0], new ArrayList<>());
//            adj.get(vertex[0]).add(vertex[1]);
//
//            if (!adj.containsKey(vertex[1])) adj.put(vertex[1], new ArrayList<>());
//            adj.get(vertex[1]).add(vertex[0]);
//
//            n = Math.max(Math.max(vertex[0], vertex[1]), n);
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (!visited.contains(i) && adj.containsKey(i)) {
//                dfs(adj, visited, i, -1, result);
//            }
//        }
//
//        return result.get(result.size() - 1);
//    }

//    void dfs(HashMap<Integer, List<Integer>> adj, HashSet<Integer> visited, int v, int par, List<int[]> result) {
//        visited.add(v);
//
//        for (int u : adj.get(v)) {
//            if (u == par) continue;
//
//            if (visited.contains(u)) {
//                result.add(new int[] { v, u });
//            } else {
//                dfs(adj, visited, u, v, result);
//            }
//        }
//    }
//}
