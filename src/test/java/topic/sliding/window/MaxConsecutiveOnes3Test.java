package topic.sliding.window;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MaxConsecutiveOnes3Test {
    MaxConsecutiveOnes3 obj = new MaxConsecutiveOnes3();

    @Test()
    public void case1() {
        assertThat(obj.longestOnes(new int[] { 1,1,1,0,0,0,1,1,1,1,0 }, 2)).isEqualTo(6);
    }

    @Test()
    public void case2() {
        assertThat(obj.longestOnes(new int[] { 0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1 }, 3)).isEqualTo(10);
    }
}

