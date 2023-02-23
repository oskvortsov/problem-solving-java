package others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class JumpGame2 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (j < nums.length) {
                    dp[j] = Math.min(dp[i] + 1, dp[j]);
                }
            }
        }



        return dp[nums.length - 1];
    }

    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String opr: operations) {
            switch(opr) {
                case "X++","++X" -> ans++;
                case "--X","X--" -> ans--;
            }
        }

        return ans;
    }

    // 1010011 -> 0101100
    public int findComplement(int num) {
        char[] binary = Integer.toBinaryString(num).toCharArray();
        int ans = 0;

        for (char bit: binary) {
            if (bit == '0') {
                ans |= 1;
            }

            ans <<= 1;
        }

        return ans;
    }

}
