package others;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();

        for (int i : nums) {
            int count = map.getOrDefault(i, 0);
            map.put(i, ++count);

            if (count > nums.length / 2) {
                return i;
            }
        }

        return -1;
    }

    public int majorityElement1(int[] nums) {
        int me = nums[0];
        int count = 0;

        for (int i : nums) {
            if (nums[i] == me) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                me = nums[i];
                count = 1;
            }
        }

        return me;
    }
}
