package topic.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreatestCommonDivisorOfStringsTest {
    @Test()
    public void case1() {
        GreatestCommonDivisorOfStrings obj = new GreatestCommonDivisorOfStrings();

        assertThat(obj.gcdOfStrings("ABCABC", "ABC")).isEqualTo("ABC");
        assertThat(obj.gcdOfStrings("ABABAB", "ABAB")).isEqualTo("AB");
        assertThat(obj.gcdOfStrings("LEET", "CODE")).isEqualTo("");
        assertThat(obj.gcdOfStrings(
                "TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX")
        ).isEqualTo("TAUXX");
    }
}
