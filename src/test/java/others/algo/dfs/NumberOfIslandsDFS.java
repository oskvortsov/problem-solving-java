package others.algo.dfs;

public class NumberOfIslandsDFS {
    private final int[][] STEPS = {
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 }
    };

    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    researchIsland(grid, visited, i, j);
                }
            }
        }

        return count;
    }

    private void researchIsland(char[][] grid, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        grid[x][y] = '0';

        for (int[] step: STEPS) {
            int dx = x + step[0], dy = y + step[1];

            if (!isOutOfMatrix(dx, dy, grid) && !visited[dx][dy] && grid[dx][dy] == '1') {
                researchIsland(grid, visited, dx, dy);
            }
        }
    }

    private boolean isOutOfMatrix(int x, int y, char[][] grid) {
        return x == -1 || x >= grid.length || y < 0 || y >= grid[0].length;
    }
}
