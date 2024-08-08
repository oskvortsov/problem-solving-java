package topic.sliding.window;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SubstringWithConcatenationOfAllWordsTest {
    @Test
    public void case1() {
        SubstringWithConcatenationOfAllWords obj = new SubstringWithConcatenationOfAllWords();
        assertThat(obj.findSubstring("barfoothefoobarman", new String[] { "foo","bar" })).isEqualTo(List.of(0, 9));
    }

    @Test
    public void case2() {
        SubstringWithConcatenationOfAllWords obj = new SubstringWithConcatenationOfAllWords();
        assertThat(obj.findSubstring("wordgoodgoodgoodbestword", new String[] { "word","good","best","word" })).isEqualTo(List.of());
    }

    @Test
    public void case3() {
        SubstringWithConcatenationOfAllWords obj = new SubstringWithConcatenationOfAllWords();
        assertThat(obj.findSubstring("barfoofoobarthefoobarman", new String[] { "bar","foo","the" })).isEqualTo(List.of(6,9,12));
    }

    @Test
    public void case4() {
        SubstringWithConcatenationOfAllWords obj = new SubstringWithConcatenationOfAllWords();
        assertThat(obj.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good" })).isEqualTo(List.of(8));
    }

    @Test
    public void case5() {
        SubstringWithConcatenationOfAllWords obj = new SubstringWithConcatenationOfAllWords();
        assertThat(obj.findSubstring("aaaaaaaaaaaaaa", new String[] { "aa", "aa" })).isEqualTo(List.of(0,1,2,3,4,5,6,7,8,9,10));
    }

    @Test
    public void case6() {
        SubstringWithConcatenationOfAllWords obj = new SubstringWithConcatenationOfAllWords();
        assertThat(obj.findSubstring("ababaab", new String[] { "ab","ba","ba" })).isEqualTo(List.of(1));
    }
}
