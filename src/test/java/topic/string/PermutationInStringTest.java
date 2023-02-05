package topic.string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PermutationInStringTest {
    @Test()
    public void case1() {
        PermutationInString pin = new PermutationInString();
        assertThat(pin.checkInclusion("adc", "dcda")).isTrue();
        assertThat(pin.checkInclusion("abc", "ccccbbbbaaaa")).isFalse();
    }
}
