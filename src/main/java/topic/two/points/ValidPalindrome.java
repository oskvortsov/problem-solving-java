package topic.two.points;

// https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        s = s.toLowerCase();

        while (l < r) {
            if (!isAlphanumeric(s.charAt(l))) {
                l++;
                continue;
            }

            if (!isAlphanumeric(s.charAt(r))) {
                r--;
                continue;
            }

            if (s.charAt(l++) != s.charAt(r--)) return false;
        }

        return true;
    }

    private boolean isAlphanumeric(char c) {
        return Character.isDigit(c) || Character.isAlphabetic(c);
    }
}
