package others;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IPOTest {
    IPO ipo = new IPO();

    @Test()
    public void case1() {
        assertThat(
                ipo.findMaximizedCapital(2, 0, new int[] { 1,2,3 }, new int[] { 0, 1, 1 })
        ).isEqualTo(4);
    }

    @Test()
    public void case2() {
        assertThat(
                ipo.findMaximizedCapital(3, 0, new int[] { 1,2,3 }, new int[] { 0, 1, 2 })
        ).isEqualTo(6);
    }

    @Test()
    public void case3() {
        assertThat(
                ipo.findMaximizedCapital(11, 11, new int[] { 1,2,3 }, new int[] { 11, 12, 13 })
        ).isEqualTo(17);
    }
}

