package topic.bit.manipulation;

// https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/

import java.util.ArrayList;
import java.util.List;

public class SumOfValuesIndicesWithKSetBits {
    private int countBits(int num) {
        int res  = 0;

        while (num != 0) {
            if ((num & 1) != 0) res++;
            num >>= 1;
        }

        return res;
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;

        for (int idx = 0; idx < nums.size(); idx++) {
            if (countBits(idx) == k) res += nums.get(idx);
        }

        return res;
    }
}
