package others.algo.dfs;

import org.junit.Test;
import topic.algo.bfs.dfs.TargetSum;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetSumTest {
    @Test()
    public void case1() {
        TargetSum ts = new TargetSum();
        assertThat(ts.findTargetSumWays(new int[] { 1, 1, 1, 1, 1}, 3)).isEqualTo(5);
        assertThat(ts.findTargetSumWays(new int[] { 1 }, 1)).isEqualTo(1);
    }
}
