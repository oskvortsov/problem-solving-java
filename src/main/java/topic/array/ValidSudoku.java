package topic.array;


import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] tiles = new boolean[9][9];
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = Character.digit(board[i][j], 10) - 1;
                    int tilesNum = 3 * (i / 3) + j / 3;

                    if (rows[i][num] || columns[j][num] || tiles[tilesNum][num]) {
                        return false;
                    }

                    tiles[tilesNum][num] = true;
                    rows[i][num] = true;
                    columns[j][num] = true;
                }
            }
        }

        return true;
    }
}
