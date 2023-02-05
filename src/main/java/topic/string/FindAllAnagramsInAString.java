package topic.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO add my solution to leetcode
// https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) {
            return ans;
        }

        int size = p.length();

        int pSum = 0;
        int[] pHash = new int[26];

        int sSum = 0;
        int[] sHash = new int[26];

        for (int i = 0; i < size; i++) {
            pSum += p.codePointAt(i);
            pHash[p.charAt(i) - 'a']++;

            sSum += s.codePointAt(i);
            sHash[s.charAt(i) - 'a']++;
        }

        for (int i = size; i <= s.length(); i++) {
            if (pSum == sSum && Arrays.equals(pHash, sHash)) {
                ans.add(i - size);
            }

            if (i == s.length()) {
                break;
            }

            sSum += s.codePointAt(i) - s.codePointAt(i - size);
            sHash[s.codePointAt(i - size) - 'a']--;
            sHash[s.codePointAt(i) - 'a']++;
        }

        return ans;
    }
}
