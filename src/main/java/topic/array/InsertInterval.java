package topic.array;

// https://leetcode.com/problems/insert-interval/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][2];

        int idx = 0;
        int trueIndex = 0;
        boolean isAdded = false;

        while (idx < intervals.length) {
            if (newInterval[1] < intervals[idx][0]) {
                result[trueIndex++] = newInterval;
                isAdded = true;

                while (idx < intervals.length) {
                    result[trueIndex++] = intervals[idx++];
                }
            } else if (newInterval[0] > intervals[idx][1]) {
                result[trueIndex++] = intervals[idx];
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            }
            idx++;
        }

        if (!isAdded) {
            result[trueIndex++] = newInterval;
        }

        return Arrays.copyOf(result, trueIndex);
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<int[]> res = new ArrayList<>();

        // Case 1: No overlapping before merging intervals
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }

        // Case 2: Overlapping and merging intervals
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // Case 3: No overlapping after merging newInterval
        while (i < n) {
            res.add(intervals[i++]);
        }

        // Convert List to array
        return res.toArray(new int[res.size()][]);
    }
}
