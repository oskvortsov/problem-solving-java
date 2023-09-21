package topic.array;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String str: strs) {
            String key = getHash(str);
            List<String> value = ans.getOrDefault(key, new ArrayList<>());
            value.add(str);

            ans.put(key, value);
        }

        return new ArrayList<>(ans.values());
    }

    private String getHash(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);

        // Slow key
        // int [] letters = new int[26];
        // for (int c: word.toCharArray()) letters[c - 'a']++;

        return new String(chars);
    }
}
