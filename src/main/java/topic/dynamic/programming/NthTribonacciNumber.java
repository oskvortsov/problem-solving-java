// https://leetcode.com/problems/n-th-tribonacci-number/?envType=study-plan-v2&envId=dynamic-programming
package topic.dynamic.programming;

public class NthTribonacciNumber {
    public int tribonacci(int n) {
        int[] dp = new int[Math.max(3, n) + 1];
        dp[0] = 0; dp[1] = 1; dp[2] = 1;

        for (int i = 3; i < n; i++) dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

        return dp[n - 1];
    }
}
