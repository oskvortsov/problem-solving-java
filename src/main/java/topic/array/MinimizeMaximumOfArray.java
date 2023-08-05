package topic.array;

public class MinimizeMaximumOfArray {
    public int minimizeArrayValue(int[] nums) {
        int max = nums[0];
        long total = nums[0];

        for (int i = 1; i < nums.length; i++) {
            total += nums[i];
            max = Math.max(max, (int) Math.ceil((total + i) / (i + 1)));
        }

        return max;
    }
}
