package topic.binary.search;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-time-to-complete-trips/
public class MinimumTimeToCompleteTrips {

    private boolean isPossible(int[] travelTimes, long time, int totalTrips) {
        long curTrip = 0;

        for (int travel: travelTimes) {
            if (travel <= time) {
                curTrip += time / travel;
                continue;
            }

            break;
        }

        return curTrip >= totalTrips;
    }

    public long minimumTime(int[] time, int totalTrips) {
       Arrays.sort(time);

       long l  = 1L, r = (long) totalTrips * time[0];

       while (l < r) {
           long mid = l + (r - l) / 2;

           if (isPossible(time, mid, totalTrips)) {
               r = mid;
           } else {
               l = mid + 1;
           }
       }

       return l;
    }
}
