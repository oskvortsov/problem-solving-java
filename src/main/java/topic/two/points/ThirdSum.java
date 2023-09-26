package topic.two.points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/description/
public class ThirdSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int l = 0; l < nums.length - 2; l++) {
            if (l != 0 && nums[l] == nums[l - 1]) continue;

            int m = l + 1;
            int r = nums.length - 1;
            int target = nums[l];

            while (m < r) {
               int cur = nums[m] + nums[r];

               if (cur + target == 0) {
                   ans.add(List.of(target, nums[m++], nums[r]));
                   while (m < r && nums[m - 1] == nums[m]) m++;
               } else {
                   if (cur + target > 0) r--;
                   else m++;
               }
            }
        }

        return ans;
    }
}
