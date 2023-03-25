package topic.prefix.sum;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        int right = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            right += nums[i];
            prefix[i] += right;
        }

        int L = 0;
        int left = 0;

        int prev = Integer.MIN_VALUE;
        while (L < nums.length) {
            left += nums[L];

            if (left == prefix[L]) {
                return L;
            }

            L++;
        }

        return -1;
    }
}
