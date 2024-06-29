package topic.string;

import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/encode-and-decode-strings/description/
public class EncodeDecodeString {
    private byte move = 64;

//    public String encode(List<String> strs) {
//        var asd = strs.stream().map(this::encodeWord);
//        return asd.collect(Collectors.toList());
//    }
//
//    public List<String> decode(String str) {
//
//    }
//
//    private String encodeWord(String word) {
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < word.length(); i++) {
//            sb.append(word.codePointAt(i) + move);
//        }
//
//        return sb.toString();
//    }
//
//    private String decodeWord(String word) {
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < word.length(); i++) {
//            sb.append(word.codePointAt(i) - move);
//        }
//
//        return sb.toString();
//    }
}
