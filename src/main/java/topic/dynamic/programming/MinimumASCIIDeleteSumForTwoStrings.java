package topic.dynamic.programming;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
public class MinimumASCIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int s1Sum = 0, s2Sum = 0;

        for (int i = 1; i <= s1.length(); i++) {
            char c1 = s1.charAt(i - 1);
            s1Sum += c1;

            for (int j = 1; j <= s2.length(); j++) {
                char c2 = s2.charAt(j - 1);
                if (i == 1) s2Sum += c2;

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

        return s1Sum + s2Sum - dp[s1.length()][s2.length()] * 2;
    }

    private String printLongestCommonString(int[][] dp, String txt1, String txt2) {
        int i = txt1.length();
        int j = txt2.length();

        StringBuffer res = new StringBuffer();

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
