package topic.dynamic.programming;

// https://leetcode.com/problems/coin-change-ii/
public class CoinChangeTwo {
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
