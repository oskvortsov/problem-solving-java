package data.structure.trie;

import java.util.*;

public class WordSearch2 {
    char[][] board;
    static class Position {
        public int x;
        public int y;

        Position(int inputX, int inputY) {
            x = inputX;
            y = inputY;
        }
    }

    private final int[][] STEP = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private final HashMap<Character, List<Position>> startPosition = new HashMap<>();

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
                List<Position> list = startPosition.getOrDefault(board[i][j], new ArrayList<>());
                list.add(new Position(i, j));
                startPosition.put(board[i][j], list);
            }
        }
    }

    private boolean isWordFound(String word) {
        List<Position> availableFirstLetter = startPosition.get(word.charAt(0));

        if (availableFirstLetter == null || availableFirstLetter.isEmpty()) {
            return false;
        }

        for (Position start: availableFirstLetter) {
            boolean[][] visited = new boolean[board.length][board[0].length];

            if (traverse(start, word, 0, visited)) return true;
        }

        return false;
    }

    private boolean traverse(Position pos, String word, int curLetter, boolean[][] visited) {
        if (curLetter == word.length()) {
            return true;
        }

        if (isOutOfBoard(pos.x, pos.y, board) || board[pos.x][pos.y] != word.charAt(curLetter) || visited[pos.x][pos.y]) {
            return false;
        }

        visited[pos.x][pos.y] = true;

        for (int[] step: STEP) {
            int dx = pos.x + step[0], dy = pos.y + step[1];

            if (traverse(new Position(dx, dy), word, curLetter + 1, visited)) {
                return true;
            }
        }

        visited[pos.x][pos.y] = false;

        return false;
    }

    private boolean isOutOfBoard(int x, int y, char[][] board) {
        return x < 0 || x >= board.length || y < 0 || y >= board[0].length;
    }

}
