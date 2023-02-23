package others;

/*
Optimization:
1.sort point by x or y
2. iterate query and using binary seach for find point that we be in circle by x or y coordinate
   x - r <= px <= x + r
3. count distance and check
 */

public class QueriesOnNumberOfPointsInsideACircle {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1], r = queries[i][2];

            for (int[] point : points) {
                int dx = point[0] - x, dy = point[1] - y;

                if (dx * dx + dy * dy < r * r) {
                    res[i]++;
                }
            }
        }

        return res;
    }
}
