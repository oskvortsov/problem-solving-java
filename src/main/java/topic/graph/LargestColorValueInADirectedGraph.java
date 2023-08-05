package topic.graph;

import java.util.*;

// https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
public class LargestColorValueInADirectedGraph {


    public int largestPathValue(String colors, int[][] edges) {
        int size = colors.length();
        List<List<Integer>> graph = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] edge: edges) {
            int from = edge[0], to = edge[1];

            if (from == to) {
                return -1;
            }

            graph.get(from).add(to);
        }

        return topologicalSort(graph, colors, size);
    }

    public int topologicalSort(List<List<Integer>> graph, String colors, int size) {
        int[] inDegree = new int[size];
        int[][] dp = new int[size][26];
        int max = 1;

        for (int from = 0; from < size; from++) {
            List<Integer> edges = graph.get(from);

            for (int to: edges) {
                inDegree[to]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < size; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int index = 0;

        while (!q.isEmpty()) {
            int from = q.poll();
            max = Math.max(++dp[from][colors.charAt(from) - 'a'], max);

            if (!graph.get(from).isEmpty()) {
                for (int to: graph.get(from)) {
                    inDegree[to]--;
                    addColor(dp, from, to);

                    if (inDegree[to] == 0) {
                        q.add(to);
                    }
                }
            }
            index++;
        }

        return index < size ? -1 : max;
    }

    void addColor(int[][] dp, int from, int to) {
        for (int i = 0; i < 26; i++) {
            dp[to][i] = Math.max(dp[from][i], dp[to][i]);
        }
    }
}
