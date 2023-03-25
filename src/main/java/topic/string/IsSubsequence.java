package topic.string;

//  Is Subsequence
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length() || s.length() == 0) {
            return false;
        }
        int cur = 0;

        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(cur) == t.charAt(i)) {
                cur++;
            }

            if (cur >= s.length() - 1) {
                return true;
            }
        }

        return false;
    }
}
