package topic.string;

import java.util.HashMap;

// https://leetcode.com/problems/edit-distance/
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[] hashWord1 = new int[26];
        int[] hashWord2 = new int[26];

        StringBuffer sb = new StringBuffer();

        for (char symbol: word2.toCharArray()) {
            hashWord2[symbol - 'a']++;
        }


        int deletionOperations = 0;
        int insertOperations = 0;
        int replaceOperation = 0;

        for (char symbol: word1.toCharArray()) {
            int cur = symbol - 'a';

            if (hashWord2[cur] != 0 && hashWord1[cur] < hashWord2[cur]) {
                hashWord1[cur]++;
                sb.append(symbol);
            } else {
                deletionOperations++;
            }
        }
        insertOperations = word2.length() - sb.length();

        int indexWord1 = 0;

        for (char symbol: word2.toCharArray()) {
            int cur = symbol - 'a';
            if (hashWord1[cur] != 0) {
                if (symbol != sb.charAt(indexWord1)) {
                    replaceOperation++;
                }
                indexWord1++;
                hashWord1[cur]--;
            }
        }
        replaceOperation /= 2;

        return deletionOperations + insertOperations + replaceOperation;
    }
}
