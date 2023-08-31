package topic.dynamic.programmic;

import org.junit.Test;
import topic.dynamic.programming.MinimumFallingPathSum;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MinimumFallingPathSumTest {
    @Test
    public void case1() {
        MinimumFallingPathSum mfp = new MinimumFallingPathSum();
        assertThat(mfp.minFallingPathSum(new int[][] {
                        {2,1,3},
                        {6,5,4},
                        {7,8,9},
        })).isEqualTo(13);
    }

    @Test
    public void case2() {
        MinimumFallingPathSum mfp = new MinimumFallingPathSum();
        assertThat(mfp.minFallingPathSum(new int[][] {
                {-19,57},
                {-40,-5},
        })).isEqualTo(-59);
    }
}
