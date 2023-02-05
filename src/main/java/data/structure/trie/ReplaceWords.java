package data.structure.trie;

import java.util.HashMap;
import java.util.List;

public class ReplaceWords {
    private class Trie {
        public boolean isFinal;
        private final HashMap<Character, Trie> children;

        Trie() {
            children = new HashMap<>();
        }
    }
    private Trie root;

    ReplaceWords() {
        root = new Trie();
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String word: dictionary) {
            insert(word);
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            sb.append(shortWord(words[i]));

            if (i != words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    private void insert(String word) {
        Trie cur = root;

        for(char c: word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Trie());
            }

            cur = cur.children.get(c);
        }

        cur.isFinal = true;
    }

    private String shortWord(String word) {
        Trie cur = root;
        int count = 0;

        for (char c: word.toCharArray()) {
            if (cur.children.containsKey(c)) {
                cur = cur.children.get(c);
                count++;
            } else {
                return word;
            }

            if (cur.isFinal) {
                return word.substring(0, count);
            }
        }

        return word;
    }
}
