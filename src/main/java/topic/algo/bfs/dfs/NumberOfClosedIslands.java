package topic.algo.bfs.dfs;

import java.util.LinkedList;
import java.util.Queue;


/*

[
    [1,1,1,1,1,1,1],
    [1,0,0,0,0,0,1],
    [1,0,1,1,1,0,1],
    [1,0,1,0,1,0,1],
    [1,0,1,1,1,0,1],
    [1,0,0,0,0,0,1],
    [1,1,1,1,1,1,1]
]
 */

// https://leetcode.com/problems/number-of-closed-islands/
public class NumberOfClosedIslands {
    private final int[][] STEPS = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public int closedIsland(int[][] grid) {
        int answer = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });

        while (!queue.isEmpty()) {
            int[] ceil = queue.poll();
            int x = ceil[0], y = ceil[1];

            if (visited[x][y]) {
                continue;
            }

            visited[x][y] = true;
            boolean isAllWater = grid[x][y] == 0;

            for (int[] step : STEPS) {
                int dx = x + step[0], dy = y + step[1];

                if (!isOutOfArray(dx, dy, grid)) {
                    if (grid[dx][dy] == 0) {
                        isAllWater = false;
                    }

                    if (!visited[dx][dy]) {
                        queue.add(new int[]{dx, dy});
                    }
                }
            }

            if (isAllWater) answer++;
        }

        return answer;
    }

    private boolean isOutOfArray(int x, int y, int[][] grid) {
        return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length;
    }
}
