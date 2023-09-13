package topic.dynamic.programmic;

import org.junit.Test;
import topic.dynamic.programming.CoinChangeTwo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CoinChangeTwoTest {
    @Test()
    public void case1() {
        CoinChangeTwo obj = new CoinChangeTwo();

        assertThat(obj.change(5, new int[] { 2, 5 })).isEqualTo(1);
        assertThat(obj.change(5, new int[] { 1, 2, 5 })).isEqualTo(4);
        assertThat(obj.change(2, new int[] { 3 })).isEqualTo(0);
        assertThat(obj.change(10, new int[] { 10 })).isEqualTo(1);
    }
}
