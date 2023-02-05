package others.algo.bfs;

import org.junit.Test;
import topic.algo.bfs.ZeroOneMatrix;
import static org.assertj.core.api.Assertions.assertThat;

public class ZeroOneMatrixTest {
    @Test()
    public void case1() {
        ZeroOneMatrix solver = new ZeroOneMatrix();
        int[][] input = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        int[][] output = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 2, 1}
        };

        assertThat(solver.updateMatrix(input)).isEqualTo(output);
    }

    @Test()
    public void case2() {
        ZeroOneMatrix solver = new ZeroOneMatrix();
        int[][] input = new int[][]{
                {0, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int[][] output = new int[][]{
                {0, 1, 2},
                {1, 2, 3},
                {2, 3, 4}
        };

        assertThat(solver.updateMatrix(input)).isEqualTo(output);
    }
}
