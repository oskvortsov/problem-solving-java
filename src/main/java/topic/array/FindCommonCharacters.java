package topic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/find-common-characters/description/?envType=daily-question&envId=2024-06-05
public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        int[] dictionary = new int[26];
        Arrays.fill(dictionary, Integer.MAX_VALUE);

        for (String word: words) {
            int[] tempDictionary = new int[26];

            for (char c: word.toCharArray()) {
                tempDictionary[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                dictionary[i] = Math.min(tempDictionary[i], dictionary[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (int idx = 0; idx < dictionary.length; idx++) {
            if (dictionary[idx] != 0) {
                while (dictionary[idx] != 0) {
                    ans.add(Character.toString(idx + 'a'));
                    dictionary[idx]--;
                }
            }
        }

        return ans;
    }
}
