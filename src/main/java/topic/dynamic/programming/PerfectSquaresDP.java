package topic.dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/perfect-squares/description/?envType=study-plan-v2&envId=dynamic-programming
public class PerfectSquaresDP {
    public int numSquares(int n) {
        List<Integer> weights = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int square = i * i;

            if (square > n) break;
            weights.add(square);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i <= n; i++) {
            for (int wi: weights) {
                if (wi > i) break;
                dp[i] = Math.min(dp[i], 1 + dp[i - wi]);
            }
        }

        return dp[n];
    }

    public int numSquares1(int n) {
        List<Integer> weights = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int square = i * i;

            if (square > n) break;
            weights.add(square);
        }

        int m = weights.size();

        int[][] dp = new int[m][n + 1];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            int wi = weights.get(i);

            for (int j = 1; j <= n; j++) {

                int whole = j / wi;
                int rest = j % wi;

                if (rest == 0 && wi <= j) {
                    dp[i][j] = whole;
                } else {
                    dp[i][j] = dp[i - 1][j];

                    if (wi < j) {
                        dp[i][j] = Math.min(
                                dp[i][j],
                                dp[i][whole * wi] + dp[i][rest]
                        );
                    }
                }

            }
        }


        return dp[m - 1][n];
    }
}
