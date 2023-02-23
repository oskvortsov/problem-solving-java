package others;


/**
 *  {3, 0, 8, 4},
 *  {2, 4, 5, 7},
 *  {9, 2, 6, 3},
 *  {0, 3, 1, 0}
 **/

// https://leetcode.com/problems/max-increase-to-keep-city-skyline/solutions/
public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxRow = new int[grid.length];
        int[] maxCol = new int[grid[0].length];

        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxRow[i] = Math.max(maxRow[i], grid[i][j]);
                maxCol[i] = Math.max(maxCol[i], grid[j][i]);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ans += Math.min(maxRow[i], maxCol[j]) - grid[i][j];
            }
        }

        return ans;
    }
}
