package topic.graph;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pacific-atlantic-water-flow/
public class PacificAtlanticWaterFlow {
    private final byte PACIFIC = 1;
    private final byte ATLANTIC = 2;

    private final int[][] STEPS = new int[][] {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        byte[][] dp = new byte[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dfs(dp, heights, i, j, PACIFIC);
                }

                if (i == m - 1 || j == n - 1) {
                    dfs(dp, heights, i, j, ATLANTIC);
                }
            }
        }

        return  countResult(dp);
    }

    private List<List<Integer>> countResult(byte[][] dp) {
        List<List<Integer>> data = new ArrayList<>();
        byte PACIFIC_ATLANTIC = PACIFIC | ATLANTIC;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == PACIFIC_ATLANTIC) {
                    data.add(List.of(i, j));
                }
            }
        }

        return data;
    }

   private void dfs(byte[][] dp, int[][] heights, int x, int y, byte bit) {
        dp[x][y] |= bit;

        for (int[] step: STEPS) {
            int dx = x + step[0], dy = y + step[1];

            if (
                    dx > -1 && dx < heights.length &&
                    dy > -1 && dy < heights[0].length &&
                    ((dp[dx][dy] & bit) == 0) && heights[dx][dy] >= heights[x][y]
            ) {
                dfs(dp, heights, dx, dy, bit);
            }
        }
   }
}
