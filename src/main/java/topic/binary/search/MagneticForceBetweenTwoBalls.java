package topic.binary.search;

import java.util.Arrays;
import java.util.HashSet;

// https://leetcode.com/problems/magnetic-force-between-two-balls/
public class MagneticForceBetweenTwoBalls {
    boolean feasible(int force, int[] position, int m) {
        int prevPoint = 0;
        m--;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < position.length; i++) {
            if (position[i] - position[prevPoint] <= force) {
                min = Math.min(position[i] - position[prevPoint], min);
                if (--m == 0) return true;
                prevPoint = i;
            }
        }

        return false;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = position[0];
        int r = position[position.length - 1];
        int res = Integer.MIN_VALUE;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (feasible(mid, position, m)) {
                r = mid;
                res = Math.max(mid, res);
            } else {
                l = mid + 1;
            }
        }

        return res;
    }
}
