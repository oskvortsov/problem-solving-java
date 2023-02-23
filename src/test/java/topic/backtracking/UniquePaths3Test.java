package topic.backtracking;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UniquePaths3Test {
    @Test()
    public void case1() {
        UniquePaths3 up3 = new UniquePaths3();
        int[][] input = new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };

        assertThat(up3.uniquePathsIII(input)).isEqualTo(2);
    }
}


