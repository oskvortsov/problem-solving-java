package topic.string;

import java.util.Arrays;

// TODO add my solution to leetcode
// https://leetcode.com/problems/permutation-in-string/solutions/
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int size = s1.length();
        int[] s1Hash = new int[26];
        int s1Sum = 0;
        for (int c: s1.toCharArray()) {
            s1Sum += c;
            s1Hash[c - 'a']++;
        }

        int window = 0;
        int[] wHash = new int[26];

        for (int i = 0; i < size; i++) {
            int c = s2.codePointAt(i);
            window += s2.codePointAt(i);
            wHash[c - 'a']++;
        }

        // 'abs' - 0,1,2
        // 'dabs' - 0,1,2,3
        for (int i = size; i < s2.length(); i++) {
            if (window == s1Sum && Arrays.equals(wHash, s1Hash)) {
                return true;
            }
            int prev = s2.codePointAt(i - size);
            window -= prev;
            wHash[prev - 'a']--;

            int next = s2.codePointAt(i);
            window += next;
            wHash[next - 'a']++;
        }

        return window == s1Sum && Arrays.equals(wHash, s1Hash);

    }
}
