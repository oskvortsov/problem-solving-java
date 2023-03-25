package data.structure.union.find;

// https://leetcode.com/problems/number-of-operations-to-make-network-connected/
public class NumberOfOperationsToMakeNetworkConnected {
    class UnionFind {
        int[] root;
        int[] rank;
        int uniqRoot;

        UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            uniqRoot = n;

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
            uniqRoot--;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public int makeConnected(int n, int[][] connections) {
        UnionFind obj = new UnionFind(n);
        int cabellCapacity = 0;

        for (int[] path: connections) {
            int from = path[0], to = path[1];

            if (obj.isConnected(from, to)) {
                cabellCapacity++;
            } else {
                obj.union(from, to);
            }
        }

        return cabellCapacity + 1 >= obj.uniqRoot ? obj.uniqRoot - 1 : -1;
    }
}
