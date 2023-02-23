package topic.string;

// https://leetcode.com/problems/strictly-palindromic-number/description/
public class StrictlyPalindromicNumber {
    public boolean isStrictlyPalindromic(int n) {
        int base = 2;

        while (base <= n - 2) {
            if (!checkPalindrom(n, base++)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkPalindrom(int num, int base) {
        String baseNum = Integer.toString(num, base);
        int l = 0;
        int r = baseNum.length() - 1;

        while (l < r) {
            if (baseNum.charAt(l++) != baseNum.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}
