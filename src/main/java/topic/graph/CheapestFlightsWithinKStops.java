package topic.graph;

import java.util.*;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        boolean[] visited = new boolean[n];

        HashMap<Integer, List<int[]>> flyMap = new HashMap<>();

        for (int[] path : flights) {
            int from = path[0], to = path[1], cost = path[2];
            flyMap.computeIfAbsent(from, v -> new ArrayList<>()).add(new int[]{to, cost});
        }

        dfs(flyMap, src, dst, prices, visited, k, 0);

        return prices[dst] == 0 ? -1 : prices[dst];
    }

    private void dfs(HashMap<Integer, List<int[]>> flyMap, int src, int dst, int[] prices, boolean[] visited, int kStops, int curPrice) {
        if (prices[dst] != 0 && curPrice > prices[dst]) {
            return;
        }

        if (src == dst) {
            prices[dst] = prices[dst] == 0 ? curPrice : Math.min(prices[dst], curPrice);
            return;
        }

        if (kStops < 0) {
            return;
        }

        if (flyMap.containsKey(src)) {
            visited[src] = true;

            for (int[] path : flyMap.get(src)) {
                int to = path[0], cost = path[1];

                if (!visited[to]) {
                    dfs(flyMap, to, dst, prices, visited, kStops - 1, curPrice + cost);
                }
            }

            visited[src] = false;
        }
    }
}
