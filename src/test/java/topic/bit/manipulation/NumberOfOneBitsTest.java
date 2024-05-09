package topic.bit.manipulation;

import org.junit.Test;
import topic.backtracking.NumberOfOneBits;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfOneBitsTest {
    @Test
    public void case1() {
        NumberOfOneBits obj = new NumberOfOneBits();
        assertThat(obj.hammingWeight(11)).isEqualTo(3);
    }
}
