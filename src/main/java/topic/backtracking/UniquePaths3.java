package topic.backtracking;

// https://leetcode.com/problems/unique-paths-iii/description/
public class UniquePaths3 {
    final int[][] STEP = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    final int START = 1;
    final int END = 2;
    final int BLOCK = -1;
    final int EMPTY = 0;
    int numOfEmptyCell = 0;
    int res = 0;

    public int uniquePathsIII(int[][] grid) {
        int[] start = new int[] { 0, 0 };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == START) {
                    start = new int[] { i, j };
                }

                if (grid[i][j] == EMPTY) {
                    numOfEmptyCell++;
                }
            }
        }

        process(start[0], start[1], 0, grid, 0);

        return res;
    }

    void process(int x, int y, int visited, int[][] grid, int count) {
        for (int[] step: STEP) {
            int dx = x + step[0], dy = y + step[1];

            if (isOutOfGrid(dx, dy, grid) || isVisit(dx, dy, visited, grid[0].length)) {
                continue;
            }

            if (grid[dx][dy] == BLOCK || grid[dx][dy] == START) {
                continue;
            }

            if (grid[dx][dy] == END && count == numOfEmptyCell) {
                res++;
                continue;
            }

            process(dx, dy, visited | (1 << (dx * grid[0].length + dy)), grid, count + 1);
        }
    }

    boolean isOutOfGrid(int x, int y, int[][] grid) {
        return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length;
    }

    boolean isVisit(int x, int y, int visited, int size) {
        return (visited & (1 << (x * size + y))) != 0;
    }
}

/*

public int uniquePathsIII(int[][] grid) {
        int walkable=0;
        int x=0, y=0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]!=-1) walkable++;
                if(grid[i][j]==1) {
                    x=i;
                    y=j;
                }
            }
        }
        return solve(grid, x, y, walkable, 1);
    }

    private int solve(int[][] grid, int i, int j, int walkable, int step) {
        if(i<0 || i>=grid.length || j<0 ||j>=grid[0].length || grid[i][j]==-1)
            return 0;
        if(grid[i][j]==2) {
            if(step==walkable) return 1;
            return 0;
        }
        int count=0;
        grid[i][j]=-1;
        count += solve(grid, i-1, j, walkable, step+1);
        count += solve(grid, i+1, j, walkable, step+1);
        count += solve(grid, i, j-1, walkable, step+1);
        count += solve(grid, i, j+1, walkable, step+1);

        grid[i][j]=0;

        return count;
    }

 */
