package topic.binary.search;

// https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBananas {
    public boolean feasible(int speed, int[] piles, int h) {
        int count = 0;
        for (int pile: piles) count += (pile / speed) + (pile % speed == 0 ? 0 : 1);
        return count <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
       int l = 1, r = Integer.MAX_VALUE;

       while (l <= r) {
           int mid = l + (r - l) / 2;
           if (feasible(mid, piles, h)) r = mid - 1;
           else l = mid + 1;
       }

       return l;
    }
}
