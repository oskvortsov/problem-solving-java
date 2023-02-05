package topic.algo.bfs;

import java.util.LinkedList;

public class NumberofIslands {
    private final int[][] STEPS = {
        { 0, 1 },
        { 1, 0 },
        { 0, -1 },
        { -1, 0 }
    };

    private final char ISLAND_LAND = '1';
    private final char VISITED_LAND = '2';


    public int numIslands(char[][] grid) {
        int numberOfIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ISLAND_LAND) {
                    numberOfIsland++;
                    researchIsland(new int[] { i, j }, grid);
                }
            }
        }

        return numberOfIsland;
    }

    private void researchIsland(int[] pos, char[][] grid) {
        LinkedList<int []> q = new LinkedList<>();
        q.add(pos);

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0], y = point[1];

            if (grid[x][y] == ISLAND_LAND) {
                grid[x][y] = VISITED_LAND;

                for (int[] step: STEPS) {
                    int dx = x + step[0], dy = y + step[1];

                    if (!isOutOfMatrix(dx, dy, grid) && grid[dx][dy] != VISITED_LAND) {
                        q.add(new int[] { dx, dy });
                    }
                }
            }
        }
    }

    private boolean isOutOfMatrix(int x, int y, char[][] grid) {
        return x == -1 || x >= grid.length || y < 0 || y >= grid[0].length;
    }
}
