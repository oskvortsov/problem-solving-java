package topic.array;

// https://leetcode.com/problems/shuffle-the-array/description/
public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];

        int step = nums.length / 2;
        for (int i = 0; i < step; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[step + i];
        }

        return ans;
    }

    // nums.len = 2n
    public int[] shuffle1(int[] nums, int n) {
        for (int i = n; i < 2 * n; i++) {
            int second = nums[i] << 10;
            nums[i - n] |= second;
        }

        int mask = (int) Math.pow(2, 10) - 1;

        for (int i = n - 1; i >= 0; i--) {
            nums[2 * i + 1] = nums[i] >> 10;
            nums[2 * i] = nums[i] & mask;
        }

        return nums;
    }
}
