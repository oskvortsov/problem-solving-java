package topic.sliding.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> wordsMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int wordSize = words[0].length();

        // init words dictionary
        for (String word: words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordSize; i++) {
            result.addAll(traverse(i, wordSize, s, wordsMap, words.length));
        }

        result.sort(Integer::compareTo);

        return result;
    }

    public List<Integer> traverse(int index, int wordSize, String s, HashMap<String, Integer> wordsMap, int wordsCount) {
        int count = 0;
        HashMap<String, Integer> currentMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        while (index <= s.length() - wordSize) {
            var cur = s.substring(index, index + wordSize);

            if (!wordsMap.containsKey(cur)) {
                count = 0;
                currentMap.clear();
            } else {
                currentMap.put(cur, currentMap.getOrDefault(cur, 0) + 1);
                count++;
            }
            index += wordSize;


            while (currentMap.getOrDefault(cur, 0) > wordsMap.getOrDefault(cur, 0)) {
                int startIndex = index - count * wordSize;
                var tmp = s.substring(startIndex, startIndex + wordSize);
                currentMap.put(tmp, currentMap.get(tmp) - 1);
                count--;
            }

            if (count == wordsCount) {
                result.add(index - wordSize * count);
            }
        }

        return result;
    }

//    public List<Integer> findSubstring(String s, String[] words) {
//        HashMap<String, Integer> wordsMap = new HashMap<>();
//        List<Integer> result = new ArrayList<>();
//
//        // init words dictionary
//        for (String word: words) {
//            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
//        }
//
//        int wordSize = words[0].length();
//        int index = 0;
//        int count = 0;
//        HashMap<String, Integer> currentMap = new HashMap<>();
//
//        while (index <= s.length()) {
//            if (count == words.length) {
//                result.add(index - wordSize * count);
//                index = index + 1 - wordSize * count;
//                currentMap.clear();
//                count = 0;
//            }
//
//            if (index > s.length() - wordSize) {
//                break;
//            }
//
//            var cur = s.substring(index, index + wordSize);
//
//            if (!wordsMap.containsKey(cur)) {
//                index++;
//                count = 0;
//                currentMap.clear();
//            } else {
//                index += wordSize;
//                currentMap.put(cur, currentMap.getOrDefault(cur, 0) + 1);
//                count++;
//            }
//
//            int startIndex = index - count * wordSize;
//            while (currentMap.getOrDefault(cur, 0) > wordsMap.getOrDefault(cur, 0)) {
//                var tmp = s.substring(startIndex, startIndex + wordSize);
//                currentMap.put(tmp, currentMap.get(tmp) - 1);
//                count--;
//                startIndex += wordSize;
//            }
//        }
//
//        return result;
//    }
}
