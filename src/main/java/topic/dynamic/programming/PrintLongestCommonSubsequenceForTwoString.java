package topic.dynamic.programming;

public class PrintLongestCommonSubsequenceForTwoString {
    public String printLongestCommonSubSequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            char c1 = s1.charAt(i - 1);

            for (int j = 1; j <= s2.length(); j++) {
                char c2 = s2.charAt(j - 1);

                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + c1;
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }

        return backtracking(dp, s1, s2);
    }

    private String backtracking(int[][] dp, String txt1, String txt2) {
        int i = txt1.length();
        int j = txt2.length();

        StringBuilder res = new StringBuilder();

        while (i > 0 && j > 0) {
            char c1 = txt1.charAt(i - 1);
            char c2 = txt2.charAt(j - 1);

            if (c1 == c2) {
                res.append(c1);
                i--;
                j--;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }

        return res.reverse().toString();
    }
}
