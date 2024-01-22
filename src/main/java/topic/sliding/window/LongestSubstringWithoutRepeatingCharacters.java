package topic.sliding.window;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] buffer = new int[256];
        int ans = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while (buffer[c] != 0) {
                buffer[s.charAt(left++)]--;
            }
            buffer[c]++;
            ans = Math.max(ans, 1 + (i - left));
        }

        return ans;
    }
}
