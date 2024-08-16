package data.structure.heap;

// https://leetcode.com/problems/k-closest-points-to-origin/description/

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> Double.compare(p1.distance, p2.distance));
        for (int[] point: points) {
            Point p = new Point(point[0], point[1]);
            pq.add(p);
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            Point p = pq.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
        }

        return result;
    }

    private static class Point {
        int x;
        int y;
        double distance;

        Point(int x, int y) {
            this.x = x;
            this.y = y;

            this.distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        }
    }
}
