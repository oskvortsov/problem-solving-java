package topic.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ValidAnagramTest {
    @Test
    public void case1() {
        ValidAnagram va = new ValidAnagram();
        assertThat(va.isAnagram("anagram", "nagaram")).isTrue();
    }

    @Test
    public void case2() {
        ValidAnagram va = new ValidAnagram();
        assertThat(va.isAnagram("rat", "car")).isFalse();
    }
}
