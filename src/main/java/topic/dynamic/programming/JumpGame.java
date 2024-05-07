package topic.dynamic.programming;

// https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
public class JumpGame {
    public boolean canJump1(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        int len = nums.length;
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            if (dp[i]) {
                for (int j = i + 1; j <= i + nums[i]; j++) {
                    if (j >= len) return true;
                    dp[j] = true;
                }
            }
        }

        return dp[len - 1];
    }

    public boolean canJump(int[] nums) {
        int gasoline = 0;

        for (int n: nums) {
            if (gasoline < 0) return false;
            if (n > gasoline) gasoline = n;
            gasoline--;
        }

        return true;
    }
}
