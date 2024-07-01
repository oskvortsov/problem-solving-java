package topic.sliding.window;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowest {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - k + 1; i++) {
            minimum = Math.min(minimum, nums[i + k] - nums[i]);
        }

        return minimum;
    }
}
