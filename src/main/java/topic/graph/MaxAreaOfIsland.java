package topic.graph;

// https://leetcode.com/problems/max-area-of-island/description/

public class MaxAreaOfIsland {
    private final int[][] STEPS = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int answer = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    answer = Math.max(answer, bfs(grid, visited, i, j, 1));
                }
            }
        }

        return answer;
    }

    private int bfs(int[][] grid, boolean[][] visited, int x, int y, int count) {
        visited[x][y] = true;

        for (int[] step : STEPS) {
            int dx = x + step[0], dy = y + step[1];
            if (
                    dx > -1 && dx < grid.length && dy > -1 && dy < grid[0].length
                            && !visited[dx][dy] && grid[dx][dy] == 1
            ) {
                count += bfs(grid, visited, dx, dy, 1);
            }
        }

        return count;
    }
}
