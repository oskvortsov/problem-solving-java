package others;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class VerifyingAnAlienDictionaryTest {
    @Test()
    public void case1() {
        VerifyingAnAlienDictionary obj = new VerifyingAnAlienDictionary();
        assertThat(obj.isAlienSorted(new String[] { "hello","leetcode" }, "hlabcdefgijkmnopqrstuvwxyz")).isTrue();
        assertThat(obj.isAlienSorted(new String[] { "word","world","row" }, "worldabcefghijkmnpqstuvxyz")).isFalse();
        assertThat(obj.isAlienSorted(new String[] { "apple","app" }, "abcdefghijklmnopqrstuvwxyz")).isFalse();
    }
}
