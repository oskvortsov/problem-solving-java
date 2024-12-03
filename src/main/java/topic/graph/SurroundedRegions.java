package topic.graph;

// https://leetcode.com/problems/surrounded-regions/description/
public class SurroundedRegions {
    private final char CAPTURE = 'X';
    private final char SURROUND = 'O';

    private final int[][] STEPS = new int[][] {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (
                        board[i][j] == SURROUND &&
                        (i == 0 || j == 0 || i == m - 1 || j == n - 1)
                ) {
                    dfs(board, visited, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == SURROUND && !visited[i][j]) {
                    board[i][j] = CAPTURE;
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int x, int y) {
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        for (int[] step: STEPS) {
            int dx = x + step[0], dy = y + step[1];

            if (
                    dx > -1 && dx < board.length &&
                    dy > -1 && dy < board[0].length &&
                    board[dx][dy] == SURROUND && !visited[dx][dy]
            ) {
                dfs(board, visited, dx, dy);
            }
        }
    }
}
