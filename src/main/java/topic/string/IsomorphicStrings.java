package topic.string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> ecrypt = new HashMap<>();
        Map<Character, Character> decrypt = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char oldChar = s.charAt(i);
            char newChar = t.charAt(i);

            if (!ecrypt.containsKey(oldChar) && !decrypt.containsKey(newChar)) {
                ecrypt.put(oldChar, newChar);
                decrypt.put(newChar, oldChar);
                continue;
            }

            if (!ecrypt.containsKey(oldChar) || !decrypt.containsKey(newChar)) {
                return false;
            }

            if (ecrypt.get(oldChar) != newChar || decrypt.get(newChar) != oldChar) {
                return false;
            }
        }

        return true;
    }
}
