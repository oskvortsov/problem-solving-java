package others;

import java.lang.reflect.Array;
import java.util.*;

// https://leetcode.com/problems/most-visited-sector-in-a-circular-track/description/
public class MostVisitedSectorInCircle {
    // Case 1: If start <= end, [start, end] is the most visited.
    //
    //      s --------- n
    // 1 -------------- n
    // 1 ------ e
    //
    // Case 2: If start > end, [1, end] and [start, n] are the most visited.
    //
    //             s -- n
    // 1 -------------- n
    // 1 ------ e

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> visited = new ArrayList<>();
        int start = rounds[0], end = rounds[rounds.length - 1];

        if (start <= end) {
            track(start, end, visited);
        } else {
            track(1, end, visited);
            track(start, n, visited);
        }

        return visited;
    }

    public void track(int start, int end, List<Integer> visited) {
        for (int i = start; i <= end; i++) {
            visited.add(i);
        }
    }
}
