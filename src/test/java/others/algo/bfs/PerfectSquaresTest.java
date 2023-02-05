package others.algo.bfs;

import org.junit.Test;
import topic.algo.bfs.PerfectSquares;

import static org.assertj.core.api.Assertions.assertThat;

public class PerfectSquaresTest {
    @Test()
    public void case1() {
        PerfectSquares ps = new PerfectSquares();
        assertThat(ps.numSquares(12)).isEqualTo(3);
        assertThat(ps.numSquares(13)).isEqualTo(2);
        assertThat(ps.numSquares(1)).isEqualTo(1);
        assertThat(ps.numSquares(6)).isEqualTo(3);
        assertThat(ps.numSquares(43)).isEqualTo(3);
    }
}
