package topic.array;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);

        int ans = 0;

        for (int num: nums) {
            boolean isFirst = !set.contains(num - 1);

            if (isFirst) {
               int next = num;
               int cur = 0;

               do {
                   cur++;
                   next++;
               } while (set.contains(next));

               ans = Math.max(cur, ans);
            }
        }

        return ans;
    }
}
