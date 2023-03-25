package data.structure.union.find;

import java.util.*;

// https://leetcode.com/problems/smallest-string-with-swaps/
public class SmallestStringWithSwaps {
    class UnionFind {
        int root[];
        int rank[];

        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootY] > rank[rootX]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }

        int find(int x) {
            if (x == root[x]) {
                return x;
            }

            return root[x] = find(root[x]);
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());

        for (List<Integer> pair: pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        char[] smallestString = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            map.computeIfAbsent(uf.find(i), p -> new ArrayList<>()).add(i);
        }

        for (List<Integer> indexes: map.values()) {
            char[] orderChars = new char[indexes.size()];
            for (int i = 0; i < orderChars.length; i++) orderChars[i] = s.charAt(indexes.get(i));
            Arrays.sort(orderChars);

            for (int i = 0; i < indexes.size(); i++) {
                smallestString[indexes.get(i)] = orderChars[i];
            }
        }

        return new String(smallestString);
    }

    public String smallestStringWithSwaps1(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());

        for (List<Integer> pair: pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            map.computeIfAbsent(uf.find(i), p -> new PriorityQueue<>()).add(symbol);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(map.get(uf.find(i)).poll());
        }

        return sb.toString();
    }

}
