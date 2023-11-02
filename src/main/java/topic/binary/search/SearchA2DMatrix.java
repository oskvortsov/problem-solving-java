package topic.binary.search;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        int l = 0, r = n - 1;
        int row = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (matrix[mid][0] <= target && target <= matrix[mid][m - 1]) {
                row = mid;
                break;
            }

            if (matrix[mid][0] > target) r = mid -1;
            else l = mid + 1;
        }

        if (row == -1) return false;

        l = 0;
        r = m;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (matrix[row][mid] == target) return true;

            if (matrix[row][mid] > target) r = mid;
            else l = mid + 1;
        }


        return false;
    }
}
