package topic.math;

// https://leetcode.com/problems/three-divisors/
public class ThreeDivisors {
    // Perfect number should contain only 1, N, and Square of N (N = X * X)
    public boolean isThree(int n) {
        if (n < 3) return false;
        int i = 2, count = 0;

        while (i < n) {
            if (n % i++ == 0) count++;
            if (count > 1) return false;
        }

        return count == 1;
    }
}
