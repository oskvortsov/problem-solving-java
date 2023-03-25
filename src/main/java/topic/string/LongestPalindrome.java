package topic.string;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] map = new int[256];
        int res = 0;
        int middle = 0;

        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        for (int j : map) {
            if (middle == 0 && res % 2 != 0) {
                middle = 1;
            }

            res += j / 2;
        }

        return res * 2 + middle;
    }
}
