package topic.binary.search;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
public class CapacityToShipPackagesWithinDDays {
    public boolean possibleToDelivery(int space, int days, int[] weights) {
        int daysNeed = 1;
        int curLoad = 0;

        for (int weight : weights) {
            curLoad += weight;

            if (curLoad > space) {
                daysNeed++;
                curLoad = weight;
            }
        }

        return daysNeed <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int totalWeight = 0;

        for (int weight: weights) {
            totalWeight += weight;
            maxWeight = Math.max(maxWeight, weight);
        }

        int l = maxWeight, r = totalWeight;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (possibleToDelivery(mid, days, weights)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }

}
