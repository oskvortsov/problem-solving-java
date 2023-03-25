package topic.sliding.window;

// https://leetcode.com/problems/max-consecutive-ones-iii/
// 1,1,1,0,0,0,1,1,1,1,0
// 0,1,2,3,4,5,6,7,8,9,10
public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r;

        for (r = 0; r < nums.length; r++) {
            if (nums[r] == 0) k--;
            if (k < 0 && nums[l++] == 0) k++;
        }

        return r - l;
    }

    public int ondLongestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int countOnes = 0;
        int countZero = 0;
        int max = 0;

        while (l <= r && r < nums.length) {
            if (countZero <= k) {
                if (nums[r++] == 1) countOnes++;
                else countZero++;
            } else {
                if (nums[l++] == 1) countOnes--;
                else countZero--;
            }

            max = Math.max(max, Math.min(countZero, k) + countOnes);
        }

        return max;
    }
}
