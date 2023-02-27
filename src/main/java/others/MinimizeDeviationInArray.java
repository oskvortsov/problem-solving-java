package others;

import java.util.TreeSet;

// https://leetcode.com/problems/minimize-deviation-in-array/
public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> orderSet = new TreeSet<>();
        for (int num: nums) orderSet.add(num % 2 == 1 ? num * 2 : num);

        int min = Integer.MAX_VALUE;

        while (orderSet.last() % 2 == 0) {
            orderSet.add(orderSet.pollLast() / 2);
            int diff = orderSet.last() - orderSet.first();
            min = Math.min(diff, min);
        }

        return min;
    }
}
