package topic.algo.bfs.dfs;

// https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
public class CheckIfThereIsAValidPathInAGrid {
    public boolean hasValidPath(int[][] grid) {
        return false;
    }

    boolean isOutOfGrid(int x, int y, int[][] grid) {
        return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length;
    }
}
