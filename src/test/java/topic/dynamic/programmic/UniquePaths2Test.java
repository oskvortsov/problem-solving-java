package topic.dynamic.programmic;

import org.junit.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import topic.dynamic.programming.UniquePaths2;


public class UniquePaths2Test {
    @Test
    public void case1() {
        UniquePaths2 up2 = new UniquePaths2();
        assertThat(up2.uniquePathsWithObstacles(new int[][] { {0,0,0},{0,1,0},{0,0,0} } )).isEqualTo(2);
        assertThat(up2.uniquePathsWithObstacles(new int[][] { {0,1},{0,0} } )).isEqualTo(1);
    }
}
