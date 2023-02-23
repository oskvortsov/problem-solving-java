package data.structure.trie;

import org.junit.Test;

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

        String[] inputWords = new String[] { "oath","pea","eat","rain" };
        String [] output = new String[] { "eat","oath" };

        assertThat(ws2.findWords(input, inputWords)).isEqualTo(output);
    }
}
