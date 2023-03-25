package others.algo.bfs;

import org.junit.Test;
import topic.algo.bfs.dfs.AsFarFromLandAsPossible;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AsFarFromLandAsPossibleTest {
    @Test()
    public void case1() {
        AsFarFromLandAsPossible obj = new AsFarFromLandAsPossible();
        int[][] input = new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        int output = 2;

        assertThat(obj.maxDistance(input)).isEqualTo(output);
    }
}

