package topic.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumTest {
    @Test
    public void case1() {
        TwoSum ts = new TwoSum();
        assertThat(ts.twoSum(new int[] {2,7,11,15}, 9)).isEqualTo(new int[] { 0, 1 });
    }

    @Test
    public void case2() {
        TwoSum ts = new TwoSum();
        assertThat(ts.twoSum(new int[] { 3, 2, 4 }, 6)).isEqualTo(new int[] { 1, 2 });
    }

    @Test
    public void case3() {
        TwoSum ts = new TwoSum();
        assertThat(ts.twoSum(new int[] { 3, 3 }, 6)).isEqualTo(new int[] { 0, 1 });
    }
}
