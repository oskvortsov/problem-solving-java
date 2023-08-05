package topic.sliding.window;

// https://leetcode.com/problems/longest-repeating-character-replacement/?envType=study-plan&id=level-1

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public boolean feasiable(HashMap<Character, Integer> map, int k) {
        int max = 0;
        int sum = 0;

        for (int val: map.values()) {
            sum += val;
            max = Math.max(max, val);
        }

        return sum - max <= k;
    }

    public int characterReplacement(String s, int k) {
        int L = 0, R = 0;
        int max = 0;
        int frequency = 0;

        int[] map = new int[256];

        while (R < s.length()) {
            char c = s.charAt(R);
            map[c]++;
            frequency = Math.max(frequency, map[c]);

            while ((R - L + 1) - frequency > k) {
                map[s.charAt(L++)]--;
            }

            max = Math.max(R - L + 1, max);
            R++;
        }

        return max == 0 ? - 1 : max;
    }
}
