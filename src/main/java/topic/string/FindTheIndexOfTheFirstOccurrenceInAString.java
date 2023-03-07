package topic.string;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int prefix = 0;
        int needleSum = 0;
        int window = needle.length() - 1;

        for (int i = 0; i < haystack.length(); i++) {
            if (i <= window) {
                needleSum += needle.charAt(i);
            } else {
                prefix -= haystack.charAt(i - window - 1);
            }

            prefix += haystack.charAt(i);

            if (i >= window  && prefix == needleSum && haystack.substring(i - window, i + 1).equals(needle)) {
               return i - window;
            }
        }

        return -1;
    }
}
