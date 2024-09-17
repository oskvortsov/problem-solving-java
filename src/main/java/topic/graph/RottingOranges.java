package topic.graph;

// https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {
    private final int[][] STEPS = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        return 1;
    }

    private void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        for (int[] step : STEPS) {
            int dx = x + step[0], dy = y + step[1];
            if (
                    dx > -1 && dx < grid.length && dy > -1 && dy < grid[0].length
                            && !visited[dx][dy] && grid[dx][dy] == 2
            ) {
                bfs(grid, visited, dx, dy);
            }
        }
    }
}
