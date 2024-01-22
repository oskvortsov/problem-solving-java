package topic.sliding.window;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    public void case1() {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        assertThat(obj.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
    }

    @Test
    public void case2() {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        assertThat(obj.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
    }

    @Test
    public void case3() {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        assertThat(obj.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    }
}
