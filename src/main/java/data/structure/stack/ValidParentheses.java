package data.structure.stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> openBrackets = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '[', '{', '(' -> openBrackets.push(c);
                case ']' -> {
                    if (openBrackets.isEmpty() || openBrackets.pop() != '[') {
                        return false;
                    }
                }
                case '}' -> {
                    if (openBrackets.isEmpty() || openBrackets.pop() != '{') {
                        return false;
                    }
                }
                case ')' -> {
                    if (openBrackets.isEmpty() || openBrackets.pop() != '(') {
                        return false;
                    }
                }
            }
        }

        return openBrackets.isEmpty();
    }


}
