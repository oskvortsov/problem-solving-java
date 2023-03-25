package data.structure.trie;

import java.util.*;

public class WordSearch2 {
    class Trie {
        Trie[] children;

        Trie() {
            children = new Trie[26];
        }

        void insert(String word) {
            int index = 0;
            Trie cur = children[word.charAt(index) - 'a'];

            while (index < word.length()) {

                if (cur == null) {
                    children[word.charAt(index) - 'a'] = new Trie();
                }
            }
        }
    }
    char[][] board;

    private final HashMap<Character, List<int[]>> startPosition = new HashMap<>();

    public List<String> findWords(char[][] board, String[] words) {
        initialize(board);
        List<String> res = new ArrayList<>();

        for (String word: words) {
            if (isWordFound(word)) {
                res.add(word);
            }
        }

        return res;
    }

    private void initialize(char[][] data) {
        board = data;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                startPosition.computeIfAbsent(board[i][j], p -> new ArrayList<>()).add(new int[] { i, j});
            }
        }
    }

    private boolean isWordFound(String word) {
        List<int[]> availableFirstLetter = startPosition.get(word.charAt(0));

        if (availableFirstLetter == null || availableFirstLetter.isEmpty()) {
            return false;
        }

        for (int[] start: availableFirstLetter) {
            if (bfs(start[0], start[1], word, 0)) return true;
        }

        return false;
    }

    private boolean bfs(int x, int y, String word, int curLetter) {
        if (curLetter == word.length()) {
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(curLetter)) {
            return false;
        }

        char tmp = board[x][y];
        board[x][y] = '-';
        boolean res = bfs(x + 1, y, word, curLetter + 1) || bfs(x - 1, y, word, curLetter + 1) || bfs(x, y + 1, word, curLetter + 1) || bfs(x, y - 1, word, curLetter + 1);
        board[x][y] = tmp;

        return res;
    }
}
