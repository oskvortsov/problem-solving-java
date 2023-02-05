package data.structure.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private final Map<Character, Trie> children;
    private boolean isLastSymbolOfWord;

    public Trie() {
        isLastSymbolOfWord = false;
        children = new HashMap<>();
    }

    public void insert(String word) {
        Trie cur = this;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                Trie newNode = new Trie();
                cur.children.put(c, newNode);
            }

            cur = cur.children.get(c);

            if (i == word.length() - 1) cur.isLastSymbolOfWord = true;
        }
    }

    public boolean search(String word) {
        Trie cur = this;

        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }

            cur = cur.children.get(c);
        }

        return cur.isLastSymbolOfWord;
    }

    public boolean startsWith(String prefix) {
        Trie cur = this;

        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }

            cur = cur.children.get(c);
        }

        return true;
    }
}
