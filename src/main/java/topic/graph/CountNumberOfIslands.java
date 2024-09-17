package topic.graph;

// https://leetcode.com/problems/number-of-islands/description/
public class CountNumberOfIslands {
    private final int[][] STEPS = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    bfs(grid, visited, i, j);
                }
            }
        }

        System.out.println(visited);
        return count;
    }

    private void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        for (int[] step : STEPS) {
            int dx = x + step[0], dy = y + step[1];
            if (
                    dx > -1 && dx < grid.length && dy > -1 && dy < grid[0].length
                    && !visited[dx][dy] && grid[dx][dy] == '1'
            ) {
                bfs(grid, visited, dx, dy);
            }
        }
    }
}
