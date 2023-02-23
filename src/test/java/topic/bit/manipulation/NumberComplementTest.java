package topic.bit.manipulation;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberComplementTest {
    @Test()
    public void case1() {
        NumberComplement nc = new NumberComplement();
        assertThat(nc.findComplement(5)).isEqualTo(2);
    }
}

