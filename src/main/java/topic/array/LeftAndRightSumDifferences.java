package topic.array;

public class LeftAndRightSumDifferences {
    public int[] leftRigthDifference(int[] nums) {
        int lSum = 0, rSum = 0;
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) rSum += nums[i];
        for (int i = 0; i < nums.length; i++) {
            rSum -= nums[i];
            ans[i] = Math.abs(rSum - lSum);
            lSum += nums[i];
        }

        return ans;
    }
}

