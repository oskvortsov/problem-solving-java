package topic.bit.manipulation;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/two-out-of-three/description/
public class TwoOutOfThree {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        byte FIRST_BIT = 1;
        byte SECOND_BIT = 2;
        byte THIRD_BIT = 4;

        byte[] frequency = new byte[101];

        fillFrequencyStore(nums1, FIRST_BIT, frequency);
        fillFrequencyStore(nums2, SECOND_BIT, frequency);
        fillFrequencyStore(nums3, THIRD_BIT, frequency);

        List<Integer> list = new ArrayList<>();

        for (int idx = 1; idx < 101; idx++) {
            byte value = frequency[idx];
            if ((value & (value - 1)) != 0) list.add((int) value);
        }

        return list;
    }

    private void fillFrequencyStore(int[] nums, byte bitmask, byte[] frequency) {
        for (int num : nums) frequency[num] |= bitmask;
    }
}
