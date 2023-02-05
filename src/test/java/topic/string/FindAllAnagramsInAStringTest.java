package topic.string;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindAllAnagramsInAStringTest {
    @Test()
    public void case1() {
        FindAllAnagramsInAString obj = new FindAllAnagramsInAString();
        assertThat(obj.findAnagrams("cbaebabacd", "abc")).isEqualTo(List.of(0, 6));
        assertThat(obj.findAnagrams("abab", "ab")).isEqualTo(List.of(0, 1, 2));
    }
}
