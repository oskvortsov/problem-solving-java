package data.structure.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// "2[abc]3[cd]ef"
public class DecodeString {
    public String decodeString(String s) {
        StringBuilder word = new StringBuilder();
        StringBuilder number = new StringBuilder();
        Stack<String> wordStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();

        boolean isNumStart = false;

//        for (char c: s.toCharArray()) {
//            if (Character.isLetter(c)) {
//                word.append()
//            }
//            if (Character.isDigit(c))
//        }
        return "";
    }
}
