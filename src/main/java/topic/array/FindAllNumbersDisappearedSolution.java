package topic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// [0,1,2,3,4,5,6,7]
// [4,3,2,7,8,2,3,1]


public class FindAllNumbersDisappearedSolution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int index = 1; index <= nums.length; index++) {
            while (nums[index - 1] != index) {
                int tmp = nums[index - 1];

                if (tmp == 0) break;

                if (nums[tmp - 1] == nums[index - 1]) {
                    nums[index - 1] = 0;
                    break;
                }

                nums[index - 1] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) result.add(i + 1);
        }

        return result;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num: nums) {
            int i = Math.abs(num) - 1;
            nums[i] = -1 * Math.abs(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(i + 1);
        }

        return result;
    }
}




