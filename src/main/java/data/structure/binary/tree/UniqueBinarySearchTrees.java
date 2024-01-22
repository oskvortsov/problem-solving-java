package data.structure.binary.tree;

// https://leetcode.com/problems/unique-binary-search-trees/description/

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[Math.max(n + 1, 2)];
        dp[0] = dp[1] = 1;

        /***
            dp[4] = dp[0] * dp[3] +
                    dp[1] * dp[2] +
                    dp[2] * dp[1] +
                    dp[3] * dp[0];
        ***/

        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                int left = root - 1;
                int right = nodes - root;
                dp[nodes] += dp[left] * dp[right];
            }
        }

        return dp[n];
    }
}
