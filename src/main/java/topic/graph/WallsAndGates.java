package topic.graph;

// https://leetcode.com/problems/walls-and-gates/description/
public class WallsAndGates {
    private final int[][] STEPS = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    bfs(grid, i, j, 1);
                }
            }
        }
    }

    void bfs(int[][] grid, int x, int y, int current) {
        for (int[] step : STEPS) {
            int dx = x + step[0], dy = y + step[1];
            if (
                    dx > -1 && dx < grid.length && dy > -1 && dy < grid[0].length && grid[dx][dy] != -1
            ) {
                if (current < grid[dx][dy]) {
                    grid[dx][dy] = current;
                    bfs(grid, dx, dy, current + 1);
                }
            }
        }
    }
}
