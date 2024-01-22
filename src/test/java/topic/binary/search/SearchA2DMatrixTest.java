package topic.binary.search;

import org.junit.Test;
import topic.binary.search.SearchA2DMatrix;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchA2DMatrixTest {
    @Test
    public void case1() {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7 },
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        SearchA2DMatrix obj = new SearchA2DMatrix();
        assertThat(obj.searchMatrix(matrix, 3)).isEqualTo(true);
    }

    @Test
    public void case3() {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7 },
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        SearchA2DMatrix obj = new SearchA2DMatrix();
        assertThat(obj.searchMatrix(matrix, 13)).isEqualTo(false);
    }

    @Test
    public void case2() {
        int[][] matrix = new int[][]{{1}};

        SearchA2DMatrix obj = new SearchA2DMatrix();
        assertThat(obj.searchMatrix(matrix, 1)).isEqualTo(true);
    }

    @Test
    public void case4() {
        int[][] matrix = new int[][]{{1}, {3}};

        SearchA2DMatrix obj = new SearchA2DMatrix();
        assertThat(obj.searchMatrix(matrix, 0)).isEqualTo(false);
    }
}
