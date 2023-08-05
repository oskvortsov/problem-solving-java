package topic.prefix.sum;

public class RangeSumQuery2DImmutable {
    int[][] prefixMatrix;

    RangeSumQuery2DImmutable(int[][] matrix) {
        prefixMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int left = j == 0 ? 0 : prefixMatrix[i][j - 1];
                int up = i == 0 ? 0 : prefixMatrix[i - 1][j];
                int upLeft = i == 0 || j == 0 ? 0 : prefixMatrix[i - 1][j - 1];

                prefixMatrix[i][j] = matrix[i][j] + up + left - upLeft;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int up = row1 == 0 ? 0 : prefixMatrix[row1 - 1][col2];
        int left = col1 == 0 ? 0 : prefixMatrix[row2][col1 - 1];
        int upLeft = col1 == 0 || row1 == 0 ? 0 : prefixMatrix[row1 - 1][col1 - 1];

        return prefixMatrix[row2][col2] - up - left + upLeft;
    }
}
