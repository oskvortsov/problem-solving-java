package topic.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupAnagramsTest {
    @Test
    public void case1() {
        GroupAnagrams ga = new GroupAnagrams();
        List<List<String>> expected = new ArrayList<>();
        expected.add(List.of("eat", "tea", "ate"));
        expected.add(List.of("bat"));
        expected.add(List.of("tan", "nat"));

        List<List<String>> result = ga.groupAnagrams(new String[] { "eat","tea","tan","ate","nat","bat" });

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void case2() {
        GroupAnagrams ga = new GroupAnagrams();
        List<List<String>> expected = new ArrayList<>();
        expected.add(List.of(""));

        List<List<String>> result = ga.groupAnagrams(new String[] { "" });

        assertThat(result).isEqualTo(expected);
    }
}
