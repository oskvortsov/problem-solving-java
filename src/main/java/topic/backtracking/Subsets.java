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

    // General approach
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
