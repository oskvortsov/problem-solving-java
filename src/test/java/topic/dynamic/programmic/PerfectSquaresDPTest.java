package topic.dynamic.programmic;

import org.junit.Test;
import topic.dynamic.programming.PerfectSquaresDP;

import static org.assertj.core.api.Assertions.assertThat;

public class PerfectSquaresDPTest {
    @Test()
    public void case1() {
        PerfectSquaresDP ps = new PerfectSquaresDP();
        assertThat(ps.numSquares(12)).isEqualTo(3);
        assertThat(ps.numSquares(13)).isEqualTo(2);
        assertThat(ps.numSquares(1)).isEqualTo(1);
        assertThat(ps.numSquares(6)).isEqualTo(3);
        assertThat(ps.numSquares(43)).isEqualTo(3);
    }
}
