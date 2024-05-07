package topic.sliding.window;

// https://leetcode.com/problems/minimum-size-subarray-sum/description/
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, ans = Integer.MAX_VALUE;
        int l = 0, idx = 0;

        while (idx < nums.length) {
            if (nums[idx] == target) return 1;

            sum += nums[idx++];
            while (sum - nums[l] >= target) sum -= nums[l++];
            if (sum >= target) ans = Math.min(ans, idx - l);
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
