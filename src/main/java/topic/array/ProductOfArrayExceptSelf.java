package topic.array;

import java.lang.reflect.Array;
import java.util.Arrays;

// https://leetcode.com/problems/product-of-array-except-self/description/
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        Arrays.fill(output, 1);

        int temp = 1;
        for (int i = 0; i < n; i++) {
            output[i] *= temp;
            temp *= nums[i];
        }

        temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= temp;
            temp *= nums[i];
        }

        return output;
    }

    public int[] productExceptSelfExtraSpace(int[] nums) {
        int product = 1;
        int zerPos = -1;
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zerPos != -1) {
                    return ans;
                }

                zerPos = i;
                continue;
            }

            product *= nums[i];
        }

        if (zerPos != -1) {
            ans[zerPos] = product;
        } else {
            for (int i = 0; i < nums.length; i++) ans[i] = product / nums[i];
        }

        return ans;
    }
}
