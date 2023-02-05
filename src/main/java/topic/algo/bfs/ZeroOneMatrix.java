package topic.algo.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    private final int[][] STEPS = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public int[][] updateMatrix(int[][] mat) {
        int[][] dist = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.add(new int[] { i, j });
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];

            for (int[] step: STEPS) {
                int dx = x + step[0], dy = y + step[1];
                if (!isOutOfMatrix(dx, dy, mat)) {
                    if (dist[dx][dy] > dist[x][y] + 1) {
                        dist[dx][dy] = dist[x][y] + 1;
                        queue.add(new int[] { dx, dy });
                    }
                }
            }
        }

        return dist;
    }

    private boolean isOutOfMatrix(int x, int y, int[][] mat) {
        return x == -1 || x >= mat.length || y < 0 || y >= mat[0].length;
    }
}
