package topic.array;

// https://leetcode.com/problems/merge-intervals/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        int idx = 0;
        int[] current = intervals[idx++];

        while (idx < intervals.length) {
            if (current[1] < intervals[idx][0]) {
                result.add(current);
                current = intervals[idx];
            } else if (current[1] >= intervals[idx][0]) {
                current[1] = Math.max(intervals[idx][1], current[1]);
            }
            idx++;
        }

        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}
