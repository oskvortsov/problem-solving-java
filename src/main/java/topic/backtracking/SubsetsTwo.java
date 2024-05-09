package topic.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsTwo {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmpList, int[] nums, int start) {
        result.add(new ArrayList<>(tmpList));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            tmpList.add(nums[i]);
            backtrack(result, tmpList, nums, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        result.add(List.of());
        inorder(0, nums, result, List.of());

        return result;
    }

    private void inorder(int start, int[] nums, List<List<Integer>> result, List<Integer> tmp) {
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            var list = new ArrayList<>(tmp);
            list.add(nums[i]);

            result.add(list);

            inorder(i + 1, nums, result, list);
        }
    }
}
