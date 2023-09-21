package topic.array;

// https://leetcode.com/problems/valid-anagram/description/

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] dictionary = new int[26];

        for (int c: s.toCharArray()) dictionary[c - 'a']++;
        for (int c: t.toCharArray()) if (--dictionary[c - 'a'] == -1) return false;

        return true;
    }
}
