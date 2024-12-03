package topic.graph;

import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {
    private final int[][] STEPS = new int[][] {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int minutes = 0, freshOranges = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> rottingQueue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    rottingQueue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        while(!rottingQueue.isEmpty()) {
            int size = rottingQueue.size();

            for (int i = 0; i < size; i++) {
                int[] pair = rottingQueue.poll();
                process(grid, visited, pair[0], pair[1], rottingQueue);
            }

            freshOranges -= rottingQueue.size();
            if (!rottingQueue.isEmpty()) minutes++;
        }

        if (freshOranges != 0) {
            return -1;
        }

        return minutes;
    }

    private void process(int[][] grid, boolean[][] visited, int x, int y, Queue<int[]> rq) {
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        for (int[] step : STEPS) {
            int dx = x + step[0], dy = y + step[1];
            if (
                    dx > -1 && dx < grid.length &&
                    dy > -1 && dy < grid[0].length &&
                    !visited[dx][dy] && grid[dx][dy] == 1
            ) {
                rq.add(new int[] { dx, dy });
                grid[dx][dy] = 2;
            }
        }

    }
}
