package topic.graph;

import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
public class CountUnreachablePairsOfNodesInAnUndirectedGraph {
    class UnionFind {
        int[] root;
        int[] rank;

        UnionFind(int n) {
            root = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (root[x] == x) {
                return x;
            }

            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }

        public HashMap<Integer, Integer> getComponentsSize() {
            HashMap<Integer, Integer> componentSize = new HashMap<>();

            for (int i = 0; i < root.length; i++) {
                int parent = find(i);
                componentSize.put(parent, componentSize.getOrDefault(parent, 0) + 1);
            }

            return componentSize;
        }
    }

    public long countPairs(int n, int[][] edges) {
        UnionFind obj = new UnionFind(n);

        for (int [] path: edges) {
            obj.union(path[0], path[1]);
        }

        HashMap<Integer, Integer> cmpSizes = obj.getComponentsSize();

        long res = 0L;
        long remaingNodes = n;

        for (int size: cmpSizes.values()) {
            res += size * (remaingNodes - size);
            remaingNodes -= size;
        }

        return res;
    }
}
