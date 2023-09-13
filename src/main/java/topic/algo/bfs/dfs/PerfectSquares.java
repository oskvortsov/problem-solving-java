package topic.algo.bfs.dfs;

import java.util.HashSet;
import java.util.LinkedList;

// https://leetcode.com/problems/perfect-squares/description/?envType=study-plan-v2&envId=dynamic-programming
public class PerfectSquares {
    public int numSquares(int n) {
        LinkedList<Integer> perfectSquares = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i * i <= n; i++) {
            perfectSquares.add(i * i);
        }

        queue.add(n);
        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int sum = queue.poll();

                for (int num : perfectSquares) {
                    int diff = sum - num;

                    if (diff == 0) return step;
                    if (diff > 0 && !visited.contains(diff)) {
                        queue.add(diff);
                        visited.add(diff);
                    }
                }
            }

            step++;
        }

        return -1;
    }
}
