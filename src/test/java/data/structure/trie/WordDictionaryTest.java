package data.structure.trie;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WordDictionaryTest {
    @Test()
    public void case1() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("axxxz");
        wordDictionary.addWord("axyxz");
        wordDictionary.addWord("zxyxz");

        assertThat(wordDictionary.search("pad")).isFalse();
        assertThat(wordDictionary.search("bad")).isTrue();
        assertThat(wordDictionary.search(".ad")).isTrue();
        assertThat(wordDictionary.search("b..")).isTrue();
        assertThat(wordDictionary.search("b.d")).isTrue();
        assertThat(wordDictionary.search("b.d.")).isFalse();
        assertThat(wordDictionary.search("...")).isTrue();
        assertThat(wordDictionary.search("m.d")).isTrue();
        assertThat(wordDictionary.search("a...z")).isTrue();
        assertThat(wordDictionary.search("a...zz")).isFalse();
        assertThat(wordDictionary.search("....z")).isTrue();
        assertThat(wordDictionary.search("a.y.z")).isTrue();
        assertThat(wordDictionary.search("z.y.z")).isTrue();

        wordDictionary.addWord("phfxughjqepmeqsvqz");
        assertThat(wordDictionary.search("phfxughjqepmeqsvqz")).isTrue();
        assertThat(wordDictionary.search("phf.ugh.qepm.qsvqz")).isTrue();
        assertThat(wordDictionary.search("p................z")).isTrue();
    }

    @Test()
    public void case2() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("phfxughjqepmeqsvqz");
        assertThat(wordDictionary.search("phfxughjqepmeqsvqz")).isTrue();
        assertThat(wordDictionary.search("phf.ugh.qepm.qsvqz")).isTrue();
        assertThat(wordDictionary.search("p................z")).isTrue();
    }

    @Test()
    public void case3() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("aa");

        assertThat(wordDictionary.search("a")).isFalse();
        assertThat(wordDictionary.search(".a.")).isFalse();
        assertThat(wordDictionary.search("ab")).isFalse();
        assertThat(wordDictionary.search("a..")).isFalse();

        assertThat(wordDictionary.search("aa")).isTrue();
        assertThat(wordDictionary.search(".a")).isTrue();
        assertThat(wordDictionary.search("a.")).isTrue();
        assertThat(wordDictionary.search("..")).isTrue();

        wordDictionary.addWord("aaa");
        assertThat(wordDictionary.search("a..")).isTrue();
    }

    @Test()
    public void case4() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("ab");
        wordDictionary.addWord("aaa");

        assertThat(wordDictionary.search("a.")).isTrue();

    }
}
