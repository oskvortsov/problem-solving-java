package topic.algo.bfs.dfs;

// https://leetcode.com/problems/word-search/
public class WordSearch {
    int[][] STEPS = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && traverse(i, j, board, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean traverse(int x, int y, char[][] board, String word, int curLetter) {
        if (curLetter == word.length()) {
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(curLetter)) {
            return false;
        }

        char tmp = board[x][y];
        board[x][y] = '0';

        if (traverse(x + 1, y, board, word, curLetter + 1)) return true;
        if (traverse(x - 1, y, board, word, curLetter + 1)) return true;
        if (traverse(x, y + 1, board, word, curLetter + 1)) return true;
        if (traverse(x, y - 1, board, word, curLetter + 1)) return true;

        board[x][y] = tmp;

        return false;
    }
}
