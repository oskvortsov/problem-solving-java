package topic.binary.search;

// https://leetcode.com/problems/koko-eating-bananas/submissions/903051203/
public class KokoEatingBananas {
    public boolean feasible(int speed, int[] piles, int h) {
        for (int pile: piles) {
            h -= 1 + (pile - 1) /speed;

            if (h < 0) return false;
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int r = Integer.MIN_VALUE;
        int total = 0;
        int l = 1;

        for (int pile: piles) {
            r = Math.max(r, pile);
            total += pile;
        }
        l = 1 + (total - 1) / h;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (feasible(mid, piles, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }
}
