package data.structure.trie;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TrieTest {
    @Test()
    public void case1() {
        Trie obj = new Trie();
        String word = "trimakasi";
        assertThat(obj.search(word)).isFalse();

        obj.insert(word);
        assertThat(obj.search(word)).isTrue();
        assertThat(obj.startsWith("trima")).isTrue();
        assertThat(obj.search("trimakasiI")).isFalse();
    }
}
