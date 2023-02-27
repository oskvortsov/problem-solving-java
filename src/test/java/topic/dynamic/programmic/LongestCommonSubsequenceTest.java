package topic.dynamic.programmic;

import org.junit.Test;
import topic.dynamic.programming.LongestCommonSubsequence;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LongestCommonSubsequenceTest {
    @Test()
    public void case1() {
        LongestCommonSubsequence obj = new LongestCommonSubsequence();

        assertThat(obj.longestCommonSubsequence("bsbininm", "jmjkbkjkv")).isEqualTo(1);
        assertThat(obj.longestCommonSubsequence("abcde", "ace")).isEqualTo(3);
        assertThat(obj.longestCommonSubsequence("ace", "abcde")).isEqualTo(3);
        assertThat(obj.longestCommonSubsequence("abc", "abc")).isEqualTo(3);
        assertThat(obj.longestCommonSubsequence("abc", "def")).isEqualTo(0);
    }
}

