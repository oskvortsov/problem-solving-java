package topic.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestConsecutiveSequenceTest {
    @Test
    public void case1() {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        assertThat(obj.longestConsecutive(new int[] { 100,4,200,1,3,2 })).isEqualTo(4);
    }

    @Test
    public void case2() {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        assertThat(obj.longestConsecutive(new int[] { 0,3,7,2,5,8,4,6,0,1 })).isEqualTo(9);
    }

    @Test
    public void case3() {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        assertThat(obj.longestConsecutive(new int[] { 0,1,2,4,8,5,6,7,9,3,55,88,77,99,999999999 })).isEqualTo(10);
    }
}