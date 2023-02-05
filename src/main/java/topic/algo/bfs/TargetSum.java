package topic.algo.bfs;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return proccessOperation(0, 0, target, nums);
    }

    private int proccessOperation(int sum, int index, int target, int[] nums) {
        if (nums.length == index) {
            return sum == target ? 1 : 0;
        }

        return proccessOperation(sum + nums[index], index + 1, target, nums) +
                proccessOperation(sum - nums[index], index + 1, target, nums);
    }
}
