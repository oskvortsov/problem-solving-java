package topic.sliding.window;

import java.util.HashMap;

// https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] tArr = new int[128];
        int[] sArr = new int[128];

        for (char c: t.toCharArray()) tArr[c]++;

        int l = 0, r = 0;
        int size = Integer.MAX_VALUE, start = 0;
        int len = 0;

        while (r < s.length()) {
            char cur = s.charAt(r);

            if (tArr[cur] != 0) {
                sArr[cur]++;
                if (sArr[cur] <= tArr[cur]) len++;
            }

            if (len == t.length()) {
                char tmp = s.charAt(l);
                while (sArr[tmp] == 0 || sArr[tmp] > tArr[tmp]) {
                    if (sArr[tmp] != 0) sArr[tmp]--;
                    tmp = s.charAt(++l);
                }

                if (r - l < size) {
                    size = r - l;
                    start = l;
                }
            }

            r++;
        }

        if (size == Integer.MAX_VALUE) return "";
        return s.substring(start, start + size + 1);
    }
//    public String minWindow(String s, String t) {
//        HashMap<Character, Integer> charMap = new HashMap<>();
//        for (char c : t.toCharArray()) charMap.put(c, charMap.getOrDefault(c, 0) + 1);
//
//        int index = 0;
//        int startIndex = 0;
//        int len = 0;
//        HashMap<Character, Integer> currentMap = new HashMap<>();
//        String result = "";
//
//        while (index < s.length()) {
//            char cur = s.charAt(index);
//
//            if (charMap.containsKey(cur)) {
//                int count = currentMap.getOrDefault(cur, 0) + 1;
//                currentMap.put(cur, count);
//
//                if (count <= charMap.get(cur)) len++;
//            }
//
//            if (len == t.length()) {
//                var tmp = s.charAt(startIndex);
//                while (!currentMap.containsKey(tmp) || currentMap.getOrDefault(tmp, 0) > charMap.getOrDefault(tmp, 0)) {
//                    if (currentMap.containsKey(tmp)) currentMap.put(tmp, currentMap.get(tmp) - 1);
//                    tmp = s.charAt(++startIndex);
//                }
//
//                if (result.isEmpty() || index - startIndex < result.length()) {
//                    result = s.substring(startIndex, index + 1);
//                }
//            }
//
//            index++;
//        }
//
//        return result;
//    }
}
