package others;

// https://leetcode.com/problems/number-of-valid-clock-times/description/
public class NumberOfValidClockTimes {
    public int countTime(String time) {
        // ??:??
        int val = 1;
        int token = '?';

        char h1 = time.charAt(0), h2 = time.charAt(1);
        char m1 = time.charAt(3), m2 = time.charAt(4);

        if (h1 == token || h2 == token) {
            if (h1 == token && h2 == token) {
                val *= 24;
            } else if (h1 == token) {
                val *= h2 - '0' < 4 ? 3 : 2;
            } else {
                val *= h1 - '0' < 2 ? 10 : 4;
            }
        }

        if (m1 == token || m2 == token) {
            if (m1 == token && m2 == token) {
                val *= 60;
            } else if (m1 == token) {
                val *= 6;
            } else {
                val *= 10;
            }
        }

        return val;
    }

    public int findMinimumOperations(String s1, String s2, String s3) {
        int minLen = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int answer = 0;

        for (int i = 0; i < minLen; i++) {
            int a = s1.charAt(i), b = s2.charAt(i), c = s3.charAt(i);
            if (a == b && b == c) {
                answer++;
            } else break;
        }

        if (answer == 0) {
            return -1;
        }

        return Math.max(0, s1.length() - answer) + Math.max(0, s2.length() - answer) + Math.max(0, s3.length() - answer);
    }
}
