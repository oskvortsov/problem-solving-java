package data.structure.stack;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DecodeStringTest {
    @Test()
    public void case1() {
        DecodeString ds = new DecodeString();
        assertThat(ds.decodeString("3[a]2[bc]")).isEqualTo("aaabcbc");
    }

    @Test()
    public void case2() {
        DecodeString ds = new DecodeString();
        assertThat(ds.decodeString("3[a2[c]]")).isEqualTo("accaccacc");
    }

    @Test()
    public void case3() {
        DecodeString ds = new DecodeString();
        assertThat(ds.decodeString("2[abc]3[cd]ef")).isEqualTo("abcabccdcdcdef");
    }
}

