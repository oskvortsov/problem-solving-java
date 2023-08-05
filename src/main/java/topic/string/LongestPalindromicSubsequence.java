package topic.string;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder();
        String rS = sb.append(s).reverse().toString();
        int[][] dp = new int[s.length() + 1][s.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            char t1 = s.charAt(i - 1);

            for (int j = 1; j < dp.length; j++) {
                char t2 = rS.charAt(j - 1);

                if (t1 == t2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s.length()][rS.length()];
    }
}
