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

    @Test
    public void case3() {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        assertThat(obj.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd")).isEqualTo("abbbbbcdd");
    }

    @Test
    public void case4() {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        assertThat(obj.minWindow("a", "b")).isEqualTo("");
    }

    @Test
    public void case5() {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        assertThat(obj.minWindow("ab", "a")).isEqualTo("a");
    }

    @Test
    public void case6() {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        assertThat(obj.minWindow("cabwefgewcwaefgcf", "cae")).isEqualTo("cwae");
    }
}
