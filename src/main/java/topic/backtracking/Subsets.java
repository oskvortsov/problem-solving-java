package topic.backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/description/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of());
        inorder(0, nums, result, List.of());

        return result;
    }

    private void inorder(int start, int[] nums, List<List<Integer>> result, List<Integer> tmp) {
        for (int i = start; i < nums.length; i++) {
            var list = new ArrayList<>(tmp);
            list.add(nums[i]);

            result.add(list);

            inorder(i + 1, nums, result, list);
        }
    }
}
