package topic.sliding.window;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumSizeSubarraySumTest {
    @Test
    public void case1() {
        MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();
        assertThat(obj.minSubArrayLen(7, new int[] { 2,3,1,2,4,3 })).isEqualTo(2);
    }

    @Test
    public void case2() {
        MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();
        assertThat(obj.minSubArrayLen(4, new int[] { 1,4,4 })).isEqualTo(1);
    }

    @Test
    public void case3() {
        MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();
        assertThat(obj.minSubArrayLen(11, new int[] { 1,1,1,1,1,1,1,1 })).isEqualTo(0);
    }
}
