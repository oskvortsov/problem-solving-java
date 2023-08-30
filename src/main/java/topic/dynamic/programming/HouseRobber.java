package topic.dynamic.programming;

// https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 3) return n == 1 ? nums[0] : Math.max(nums[0], nums[1]);

        int[] dp = new int[n];
        dp[0] = nums[0]; dp[1] = nums[1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(i > 2 ? dp[i - 3] : 0, dp[i - 2]) + nums[i];
        }

        return Math.max(dp[n - 1], dp[n - 2]);
    }
}
