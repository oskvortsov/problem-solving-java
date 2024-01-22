package topic.sliding.window;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumWindowSubstringTest {
    @Test
    public void case1() {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        assertThat(obj.minWindow("ADOBECODEBANC", "ABC")).isEqualTo("BANC");
    }

    @Test
    public void case2() {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        assertThat(obj.minWindow("a", "aa")).isEqualTo("");
    }
}
