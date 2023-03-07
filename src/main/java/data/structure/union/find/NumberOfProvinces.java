package data.structure.union.find;


// https://leetcode.com/problems/number-of-provinces/description/
public class NumberOfProvinces {
    class UnionFind {
        int[] root;
        int[] rank;
        int uniqRoot;

        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            uniqRoot = size;

            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
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

        public int numOfUniqRoot() {
            return uniqRoot;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        UnionFind obj = new UnionFind(size);

        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (isConnected[i][j] == 1) obj.union(i, j);
            }
        }

        return obj.numOfUniqRoot();
    }

    void dfs(int[][] A,boolean[] visited, int sv){
        visited[sv] = true;
        for(int i=0;i<A.length;i++){
            if(!visited[i] && A[sv][i]==1){
                dfs(A,visited,i);
            }
        }
    }
    public int findCircleNum1(int[][] A) {
        boolean [] visited = new boolean[A.length];
        int cnt=0;
        for(int i=0;i<A.length;i++){
            if(!visited[i]){
                dfs(A,visited,i);
                cnt++;
            }
        }
        return cnt;
    }
}
