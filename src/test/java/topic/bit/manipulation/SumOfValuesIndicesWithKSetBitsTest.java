package topic.bit.manipulation;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SumOfValuesIndicesWithKSetBitsTest {
    @Test
    public void case1() {
        SumOfValuesIndicesWithKSetBits obj = new SumOfValuesIndicesWithKSetBits();
        assertThat(obj.sumIndicesWithKSetBits(List.of(5,10,1,5,2), 1)).isEqualTo(13);
    }

    @Test
    public void case2() {
        SumOfValuesIndicesWithKSetBits obj = new SumOfValuesIndicesWithKSetBits();
        assertThat(obj.sumIndicesWithKSetBits(List.of(4,3,2,1), 2)).isEqualTo(1);
    }
}
