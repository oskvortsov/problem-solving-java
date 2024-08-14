package topic.sliding.window;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumNumberOfFlipsToMakeBinaryStringAlteringTest {
    @Test
    public void case1() {
        MinimumNumberOfFlipsToMakeBinaryStringAltering obj = new MinimumNumberOfFlipsToMakeBinaryStringAltering();
        assertThat(obj.minFlips("111000")).isEqualTo(2);
    }

    @Test
    public void case2() {
        MinimumNumberOfFlipsToMakeBinaryStringAltering obj = new MinimumNumberOfFlipsToMakeBinaryStringAltering();
        assertThat(obj.minFlips("1110")).isEqualTo(1);
    }

    @Test
    public void case3() {
        MinimumNumberOfFlipsToMakeBinaryStringAltering obj = new MinimumNumberOfFlipsToMakeBinaryStringAltering();
        assertThat(obj.minFlips("010")).isEqualTo(0);
    }

    @Test
    public void case4() {
        MinimumNumberOfFlipsToMakeBinaryStringAltering obj = new MinimumNumberOfFlipsToMakeBinaryStringAltering();
        assertThat(obj.minFlips("01001001101")).isEqualTo(2);
    }

    @Test
    public void case5() {
        MinimumNumberOfFlipsToMakeBinaryStringAltering obj = new MinimumNumberOfFlipsToMakeBinaryStringAltering();
        assertThat(obj.minFlips("10001100101000000")).isEqualTo(5);
    }
}

