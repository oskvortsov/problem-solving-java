package topic.dynamic.programming;

// https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            int t1 = text1.charAt(i - 1);

            for (int j = 1; j <= text2.length(); j++) {
                int t2 = text2.charAt(j - 1);

                if (t1 == t2) {
                    dp[i][j] += dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public int longestCommonSubsequenceRecursion(String text1, String text2) {
        return LCS(0, 0, text1, text2);
    }

    private int LCS(int i, int j, String text1, String text2) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        } else if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + LCS(i + 1, j + 1, text1, text2);
        }

        return Math.max(
                LCS(i + 1, j, text1, text2),
                LCS(i, j + 1, text1, text2)
        );
    }
}
