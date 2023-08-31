package topic.dynamic.programming;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/triangle/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);

        for (List<Integer> row: triangle) {
            if (row.size() == 1) continue;
            int prev = Integer.MAX_VALUE;
            int cur = dp[0];

            for (int i = 0; i < row.size(); i++) {
                int val = Math.min(prev, cur) + row.get(i);
                prev = dp[i];
                cur = dp[i + 1];

                dp[i] = val;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int num: dp) min = Math.min(min, num);

        return min;
    }
}
