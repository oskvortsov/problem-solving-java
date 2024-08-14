package topic.string;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/encode-and-decode-strings/

public class StringEncodeAndDecode {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str: strs) {
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> result = new ArrayList<>();

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;
            int size = Integer.parseInt(str.substring(i, j));

            i = j + 1 + size;
            result.add(str.substring(j + 1, j + 1 + size));
        }

        return result;
    }
}
