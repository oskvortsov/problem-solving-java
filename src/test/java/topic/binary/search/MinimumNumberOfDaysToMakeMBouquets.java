package topic.binary.search;

// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
public class MinimumNumberOfDaysToMakeMBouquets {
    public boolean feasible(int day, int numBouquet, int flowerPerBouquet, int[] bloomDay) {
        int cur = 0;

        for (int bloom: bloomDay) {
            if (bloom <= day) cur++;
            else cur = 0;

            if (cur == flowerPerBouquet) {
                numBouquet--;
                cur = 0;
            }

            if (numBouquet <= 0) return true;
        }

        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int needs = m * k;
        if (bloomDay.length < needs) {
            return -1;
        }
        int l = 1, r = 0;

        for (int bloom: bloomDay) r = Math.max(r, bloom);

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (feasible(mid, m, k, bloomDay)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return feasible(r, m, k, bloomDay) ? r : -1;
    }
}
