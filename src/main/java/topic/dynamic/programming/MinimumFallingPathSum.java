package topic.dynamic.programming;

// https://leetcode.com/problems/minimum-falling-path-sum/
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minVal = matrix[i - 1][j];
                if (j > 0) minVal = Math.min(matrix[i - 1][j - 1], minVal);
                if (j < n - 1) minVal = Math.min(matrix[i - 1][j + 1], minVal);

                matrix[i][j] += minVal;

                if (i == n - 1) min = Math.min(matrix[i][j], min);
            }
        }

        return min;
    }
}
