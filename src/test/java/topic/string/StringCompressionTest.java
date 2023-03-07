package topic.string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCompressionTest {
    StringCompression obj = new StringCompression();

    @Test()
    public void shouldReturnSix() {
        char[] input = new char[]{ 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        char[] output = new char[] { 'a','2','b','2','c','3', 'c' };

        assertThat(obj.compress(input)).isEqualTo(6);
        assertThat(input).isEqualTo(output);
    }

    @Test()
    public void oneLetter() {
        char[] input = new char[]{ 'a'};
        char[] output = new char[] { 'a' };

        assertThat(obj.compress(input)).isEqualTo(1);
        assertThat(input).isEqualTo(output);
    }
    
    @Test()
    public void case3() {
        char[] input = new char[]{ 'a','b','b','b','b','b','b','b','b','b','b','b','b' };
        char[] output = new char[] { 'a','b','1','2','b','b','b','b','b','b','b','b','b' };

        assertThat(obj.compress(input)).isEqualTo(4);
        assertThat(input).isEqualTo(output);
    }
}

