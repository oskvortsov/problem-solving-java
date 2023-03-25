package topic.algo.bfs.dfs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/as-far-from-land-as-possible/
public class AsFarFromLandAsPossible {
    private final int[][] STEP = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int maxDistance(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int distance = -1;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                visited[i][j] = grid[i][j];

                if (grid[i][j] == 1) {
                    queue.offer(new int[] { i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            distance++;


            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();

                for (int[] step: STEP) {
                    int dx = pos[0] + step[0], dy = pos[1] + step[1];

                    if (!isOutOfGrid(dx, dy, grid) && visited[dx][dy] == 0) {
                        visited[dx][dy] = 1;
                        queue.add(new int[] { dx, dy });
                    }
                }
            }
        }

        return distance == 0 ? -1 : distance;

    }

    private boolean isOutOfGrid(int x, int y, int[][] grid) {
        return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length;
    }
}

// https://leetcode.com/problems/as-far-from-land-as-possible/
//public class AsFarFromLandAsPossible {
//    private final int[][] STEP = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//
//    public int maxDistance(int[][] grid) {
//        int max = 0;
//        Queue<int[]> waters = new LinkedList<>();
//
//        for (int i = 0; i < grid.length; i++) {
//            for(int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == 0) {
//                    waters.add(new int[] { i, j });
//                }
//            }
//        }
//
//        if (waters.size() == 0 || waters.size() == grid.length * grid[0].length) {
//            return -1;
//        }
//
//        for (int[] pos : waters) {
//            max = Math.max(searchDistance(pos[0], pos[1], grid), max);
//        }
//
//        return max;
//    }
//
//    private int searchDistance(int x, int y, int[][] grid) {
//        boolean[][] visited = new boolean[grid.length][grid[0].length];
//
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[] { x, y });
//
//        while (!queue.isEmpty()) {
//            int[] pos = queue.poll();
//
//            for (int[] step: STEP) {
//                int dx = pos[0] + step[0], dy = pos[1] + step[1];
//                if (!isOutOfGrid(dx, dy, grid) && !visited[dx][dy]) {
//                    if (grid[dx][dy] == 1) {
//                        return Math.abs(dx - x) + Math.abs(dy - y);
//                    }
//
//                    visited[dx][dy] = true;
//                    queue.add(new int[] { dx, dy });
//                }
//            }
//        }
//
//        return 0;
//    }
//
//    private boolean isOutOfGrid(int x, int y, int[][] grid) {
//        return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length;
//    }
//}

