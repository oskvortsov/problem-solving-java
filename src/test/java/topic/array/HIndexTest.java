package topic.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HIndexTest {
    @Test
    public void case1() {
        HIndex obj = new HIndex();
        assertThat(obj.hIndex(new int[] { 3,0,6,1,5 })).isEqualTo(3);
    }

    @Test
    public void case2() {
        HIndex obj = new HIndex();
        assertThat(obj.hIndex(new int[] { 1,3,1 })).isEqualTo(1);
    }

    @Test
    public void case3() {
        HIndex obj = new HIndex();
        assertThat(obj.hIndex(new int[] { 1 })).isEqualTo(1);
    }

    @Test
    public void case4() {
        HIndex obj = new HIndex();
        assertThat(obj.hIndex(new int[] { 0, 1 })).isEqualTo(1);
    }
}
