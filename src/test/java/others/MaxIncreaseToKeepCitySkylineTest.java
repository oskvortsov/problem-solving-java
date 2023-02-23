package others;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MaxIncreaseToKeepCitySkylineTest {
    @Test()
    public void case1() {
        MaxIncreaseToKeepCitySkyline obj = new MaxIncreaseToKeepCitySkyline();
        int[][] input = new int[][]{
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };
        assertThat(obj.maxIncreaseKeepingSkyline(input)).isEqualTo(35);
    }
}

