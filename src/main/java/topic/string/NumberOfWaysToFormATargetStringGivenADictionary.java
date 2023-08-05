package topic.string;

import java.util.*;

public class NumberOfWaysToFormATargetStringGivenADictionary {
    public int numWays(String[] words, String target) {
        Set<Character> targetSet = new HashSet<>();
        for (char c: target.toCharArray()) targetSet.add(c);

        int size = words[0].length();
        List<Character>[] dict = new List[size];


        for (int i = 0; i < size; i++) {

            dict[i] = new ArrayList<>();

            for (String word: words) {
                char c = word.charAt(i);
                if (targetSet.contains(c)) {
                    dict[i].add(c);
                }
            }
        }

        int[][] dp = new int[size][26];
        for (int i = 0; i < size; i++) {
            Arrays.fill(dp[i], -1);
        }

        return countPossibleWord(0, 0, target, dict, dp);
    }

    public int countPossibleWord(int index, int tIndex, String target, List<Character>[] dict, int[][] dp) {
        int wSize = dict.length;
        int tSize = target.length();
        int res = 0;

        if (tIndex == target.length()) {
            return 1;
        }

        int targetChar = target.charAt(tIndex);

        if (dp[index][targetChar - 'a'] != -1) {
            return dp[index][targetChar];
        }

        int last = wSize - (tSize - tIndex - 1);
        for (int i = index; i < last; i++) {

            for (char w: dict[i]) {
                if (w == targetChar) {
                    res += countPossibleWord(i + 1, tIndex + 1, target, dict, dp);
                }
            }
        }

        return res;
    }
}
