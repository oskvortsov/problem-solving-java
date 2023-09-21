package topic.array;

import java.util.ArrayList;
import java.util.HashMap;

// https://leetcode.com/problems/two-sum/

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> value = map.getOrDefault(nums[i], new ArrayList<>());
            value.add(i);
            int rest = target - nums[i];

            if (map.containsKey(rest)) {
                ans[0] = map.get(rest).get(0);
                ans[1] = i;

                return ans;
            }

            map.put(nums[i], value);
        }

        return ans;
    }
}
