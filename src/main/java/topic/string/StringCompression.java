package topic.string;

// https://leetcode.com/problems/string-compression/
public class StringCompression {
    public int compress(char[] chars) {
        int prev = 0;
        int index = 0;

        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[prev] != chars[i]) {
                int count = i - prev;

                chars[index++] = chars[prev];

                if (count > 1) {
                    for (char num: Integer.toString(count).toCharArray()) {
                        chars[index++] = num;
                    }
                }

                prev = i;
            }
        }

        return index;
    }
}
