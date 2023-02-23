package data.structure.trie;

import java.util.List;

public class WordSearch2 {
    class Node {
        Node[] children;
        char val;

        Node() {
            children = new Node[26];
        }
    }

    private final int[][] STEP = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    Node root = new Node();


    public List<String> findWords(char[][] board, String[] words) {
        return List.of();
    }
}
