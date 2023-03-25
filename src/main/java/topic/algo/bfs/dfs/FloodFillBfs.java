package topic.algo.bfs.dfs;

public class FloodFillBfs {
    private final int[][] STEPS = {
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 }
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void fill(int[][] image, int x, int y, int baseColor, int color) {
        if (baseColor == color) return;
        image[x][y] = color;

        for (int[] pos: STEPS) {
            int dx = x + pos[0], dy = y + pos[1];

            if (!isOutOfMatrix(dx, dy, image) && image[dx][dy] == baseColor) {
                fill(image, dx, dy, baseColor, color);
            }
        }
    }

    private boolean isOutOfMatrix(int x, int y, int[][] image) {
        return x == -1 || x >= image.length || y < 0 || y >= image[0].length;
    }
}
