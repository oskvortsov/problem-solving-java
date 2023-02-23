package topic.dynamic.programming;


// [10,15,20] -> 15
// [1,100,1,1,1,100,1,1,100,1] -> 6s

// https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        int[] dp = new int[size];

        for (int i = 2; i < dp.length; i++) dp[i] = Integer.MAX_VALUE;
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(
                    dp[i - 2] + cost[i],
                    dp[i - 1] + cost[i]
            );
        }

        return Math.min(dp[size - 1], dp[size - 2]);
    }
}
