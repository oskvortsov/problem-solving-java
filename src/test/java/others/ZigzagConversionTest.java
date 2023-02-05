package others;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ZigzagConversionTest {
    @Test()
    public void case1() {
        ZigzagConversion zc = new ZigzagConversion();
//        assertThat(zc.convert("PAYPALISHIRING", 3)).isEqualTo("PAHNAPLSIIGYIR");
//        assertThat(zc.convert("PAYPALISHIRING", 4)).isEqualTo("PINALSIGYAHRPI");
//        assertThat(zc.convert("A", 1)).isEqualTo("A");
        assertThat(zc.convert("AB", 1)).isEqualTo("AB");
        assertThat(zc.convert("ABC", 2)).isEqualTo("ACB");
//        assertThat(zc.convert("123456789", 3)).isEqualTo("159246837");
    }
}
