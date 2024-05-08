package topic.backtracking;

import java.util.ArrayList;
import java.util.List;


public class Permutations {
    private int finalMask;
    private List<List<Integer>> result;


    // optimize method with bit map
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        finalMask = (int) Math.pow(2, nums.length) - 1;

        int[] positions = new int[nums.length];
        backtracking(nums, positions, 0, 0);

        return result;
    }

    private void backtracking(int[] nums, int[] positions, int mask, int index) {
        if (mask == finalMask) {
            addPermutation(nums, positions);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // check that current bit haven't been used before
            if ((mask & 1 << i) != 0) continue;

            // keep position for current number
            positions[index] = i;
            backtracking(nums, positions, mask | 1 << i, index + 1);
        }
    }

    private void addPermutation(int[] nums, int[] positions) {
        List<Integer> tmp = new ArrayList<>();
        for (int idx: positions) tmp.add(nums[idx]);
        result.add(tmp);
    }

//    public List<List<Integer>> permute2(int[] nums) {
//        result = new ArrayList<>();
//        backtracking1(result, new ArrayList<>(), nums);
//        return result;
//    }
//
//    private void backtracking1(List<List<Integer>> result, List<Integer> tmp, int[] nums) {
//        if (tmp.size() == nums.length) {
//            result.add(new ArrayList<>(tmp));
//            return;
//        }
//
//        for (int num : nums) {
//            if (tmp.contains(num)) continue;
//            tmp.add(num);
//            backtracking1(result, tmp, nums);
//            tmp.remove(tmp.size() - 1);
//        }
//    }
}
