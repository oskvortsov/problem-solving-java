package data.structure.trie;

import java.util.Arrays;

public class WordDictionary {
    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;

        for (char c: word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }

            cur = cur.children[c - 'a'];
        }

        cur.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode node) {
        TrieNode cur = node;

        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean isLast = i == word.length() - 1;

            if (c == '.') {
                for (TrieNode child: cur.children) {
                    if (child != null) {
                        if (isLast) {
                            if (child.isEnd) {
                                return true;
                            }
                            continue;
                        }

                        if (search(word, i + 1, child)) {
                            return true;
                        }
                    }
                }

                return false;
            }

            if (cur.children[c - 'a'] == null) {
                return false;
            }

            cur = cur.children[c - 'a'];
        }

        return cur.isEnd;
    }
}

class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    TrieNode() {
        children = new TrieNode[26];
    }
}
