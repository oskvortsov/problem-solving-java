package data.structure.stack;

// https://leetcode.com/problems/remove-outermost-parentheses/description/

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        int count = 0;
        int start = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == '(' ? -1 : 1;

            if (count == 0) {
                sb.append(s, start + 1, i - 1);
                start = i + 1;
            }
        }

        return sb.toString();
    }
}
