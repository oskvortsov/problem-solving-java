package topic.sliding.window;

import java.util.Arrays;

// https://leetcode.com/problems/3sum-closest/description/

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int answer = Integer.MAX_VALUE;
        int prevDistance = Integer.MAX_VALUE;

        for (int l = 0; l < nums.length - 2; l++) {
            if (l != 0 && nums[l] == nums[l - 1]) continue;

            int m = l + 1, r = nums.length - 1;

            while (m < r) {
                int curr = nums[l] + nums[m] + nums[r];
                int distance = Math.abs(target - curr);

                if (curr == target) return target;

                if (distance < prevDistance) {
                    prevDistance = distance;
                    answer = curr;
                }

                if (curr > target) {
                    r--;
                } else {
                    m++;
                    while (m < r && nums[m] == nums[m - 1]) m++;
                }
            }
        }

        return answer;
    }

    public int threeSumClosest1(int[] nums, int target) {
        int answer = Integer.MAX_VALUE;
        int preDistance = Integer.MAX_VALUE;

        for (int l = 0; l < nums.length - 2; l++) {
            for (int m = l + 1; m < nums.length - 1; m++) {
                for (int r = m + 1; r < nums.length; r++) {
                    int val = nums[l] + nums[m] + nums[r];
                    int distance = answer;

                    if (target < 0 && val > 0 || target > 0 && val < 0) {
                        distance = Math.abs(target + val);
                    } else {
                        distance = Math.abs(target - val);
                    }

                    if (distance < preDistance) {
                        System.out.printf("%d %d %d = %d %n", l,m,r, distance);
                        preDistance = distance;
                        answer = val;
                    }
                }
            }
        }

        return answer;
    }
}
