package topic.dynamic.programming;
import java.util.Arrays;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int[][] col: dp) for(int[] row: col) Arrays.fill(row, -1);

        return max(strs.length, m, n, strs, dp);
    }

    private int max(int index, int mm, int nn, String strs[], int[][][] dp) {
        if (mm < 0 || nn < 0) return -1;
        if (index == 0) return 0;

        if (dp[index][mm][nn] != -1) return dp[index][mm][nn];

        int nCount = countZeros(strs[index - 1]);
        int mCount = strs[index - 1].length() - nCount;

        dp[index][mm][nn] = Math.max(
                max(index - 1, mm, nn, strs, dp),
                1 + max(index - 1, mm - mCount, nn - nCount, strs, dp)
        );

        return  dp[index][mm][nn];
    }

    private int countZeros(String s) {
        int count = 0;
        for (char c: s.toCharArray()) if (c == '1') count++;

        return count;
    }
}
