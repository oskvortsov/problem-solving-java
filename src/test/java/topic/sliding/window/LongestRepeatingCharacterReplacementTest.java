package topic.sliding.window;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestRepeatingCharacterReplacementTest {
    @Test
    public void case1() {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
        assertThat(obj.characterReplacement("ABAB", 2)).isEqualTo(4);
    }

    @Test
    public void case2() {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
        assertThat(obj.characterReplacement("AABABBA", 1)).isEqualTo(4);
    }

    @Test
    public void case3() {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
        assertThat(obj.characterReplacement("ABAA", 0)).isEqualTo(2);
    }

    @Test
    public void case4() {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
        assertThat(obj.characterReplacement("ABBB", 2)).isEqualTo(4);
    }

    @Test
    public void case5() {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
        assertThat(obj.characterReplacement("ABCBB", 2)).isEqualTo(5);
    }
}
