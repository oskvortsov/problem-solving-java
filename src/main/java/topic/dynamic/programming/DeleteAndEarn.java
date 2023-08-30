package topic.dynamic.programming;

import java.util.HashMap;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num: nums) max = Math.max(max, num);

        int[] dp = new int[max + 1];
        for (int num: nums) dp[num] += num;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + dp[i], dp[i - 1]);
        }

        return dp[max];
    }

    public int deleteAndEarn1(int[] nums) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num: nums) {
            sums.put(num, sums.getOrDefault(num, 0) + num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int n = (max - min) + 2;
        int[] dp = new int[n];

        for (int i = min - 1; i <= max; i++) {
            int index = i - min + 1;
            dp[index] = sums.getOrDefault(i, 0);
        }

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 3], dp[i - 2]) + dp[i];
        }


        return Math.max(dp[n - 1], dp[n - 2]);
    }
}
