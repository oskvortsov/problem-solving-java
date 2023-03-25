package data.structure.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/
public class LargestNumberAfterDigitSwapsByParity {
    public int largestInteger(int num) {
        PriorityQueue<Integer> pqOdd = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pqEven = new PriorityQueue<>((a, b) -> b - a);
        List<Integer> nums = new ArrayList<>();


        while (num > 0) {
            int cur = num % 10;

            if (cur % 2 == 0) pqEven.add(cur);
            else pqOdd.add(cur);

            nums.add(cur);
            num /= 10;
        }


        int res = 0;
        for (int i = nums.size() - 1; i > -1; i--) {
            int power = (int) Math.pow(10, i);

            if (nums.get(i) % 2 == 0) {
                res += pqEven.poll() * power;
            } else {
                res += pqOdd.poll() * power;
            }
        }

        return res;
    }
}
