package topic.bit.manipulation;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-prefix-divisible-by-5/description/

public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answers = new ArrayList<>();
        int val = 0;

        for (int num : nums) {
//            val <<= 1;
//            val |= num;
//            val %= 5;
            val = ((val << 1) + num) % 5;

            System.out.println(val);
            answers.add(val % 5 == 0);
        }

        return answers;
    }
}
