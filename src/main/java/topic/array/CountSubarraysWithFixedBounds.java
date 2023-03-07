package topic.array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-subarrays-with-fixed-bounds/
public class CountSubarraysWithFixedBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int start = 0, minStart = 0, maxStart = 0;
        boolean minFound = false, maxFound = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                minFound = false;
                maxFound = false;
                start = i + 1;
            }

            if (nums[i] == minK) {
                minFound = true;
                minStart = i;
            }

            if (nums[i] == maxK) {
                maxStart = i;
                maxFound = true;
            }

            if (maxFound && minFound) {
                res += 1 + Math.min(minStart, maxStart) - start;
            }
        }

        return res;
    }
}
