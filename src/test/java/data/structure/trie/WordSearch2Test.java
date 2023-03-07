package data.structure.trie;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WordSearch2Test {
    @Test()
    public void case1() {
        WordSearch2 ws2 = new WordSearch2();
        char[][] input = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] inputWords = new String[]{"oath", "pea", "eat", "rain"};
        List<String> output = List.of("oath", "eat");

        assertThat(ws2.findWords(input, inputWords)).isEqualTo(output);
    }


    @Test()
    public void case2() {
        WordSearch2 ws2 = new WordSearch2();
        char[][] input = new char[][]{
                {'a', 'b', 'c'},
                {'a', 'e', 'd'},
                {'a', 'f', 'g'},
        };

        String[] inputWords = new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"};
        List<String> output = List.of("abcdefg","gfedcbaaa", "eaabcdgfa", "befa");

        assertThat(ws2.findWords(input, inputWords)).isEqualTo(output);
    }
}
