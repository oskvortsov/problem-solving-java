package others;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        long l = 0;
        long r = num / 2;
        long mid = r - ((r - l) / 2);

        while (l <= r) {
            long square = mid * mid;

            if (square == num) {
                return true;
            }

            if (square > num || square < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

            mid = r - ((r - l) / 2);
        }

        return false;
    }
}
