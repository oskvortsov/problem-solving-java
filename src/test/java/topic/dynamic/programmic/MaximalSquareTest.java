package topic.dynamic.programmic;

import org.junit.Test;
import topic.dynamic.programming.MaximalSquare;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MaximalSquareTest {
    @Test()
    public void case1() {
        MaximalSquare ms = new MaximalSquare();
        assertThat(ms.maximalSquare(new char[][]{{'0', '1'}, {'1', '0'}})).isEqualTo(1);
    }

    @Test()
    public void case2() {
        MaximalSquare ms = new MaximalSquare();
        assertThat(ms.maximalSquare(new char[][]{{'0', '1'}})).isEqualTo(1);
    }
}
