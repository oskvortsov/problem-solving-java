package topic.two.points;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ThirdSumTest {
    @Test
    public void case1() {
        ThirdSum obj = new ThirdSum();
        assertThat(obj.threeSum(new int[] { -1,0,1,2,-1,-4 })).isEqualTo(List.of(
                List.of(-1, -1, 2), List.of(-1, 0, 1)
        ));
    }

    @Test
    public void case2() {
        ThirdSum obj = new ThirdSum();
        assertThat(obj.threeSum(new int[] { 0,1,1 })).isEqualTo(List.of());
    }

    @Test
    public void case3() {
        ThirdSum obj = new ThirdSum();
        assertThat(obj.threeSum(new int[] { 0,0,0 })).isEqualTo(List.of(List.of(0,0,0)));
    }

    @Test
    public void case4() {
        ThirdSum obj = new ThirdSum();
        assertThat(obj.threeSum(new int[] { 0,0,0,0,0,0 })).isEqualTo(List.of(List.of(0,0,0)));
    }

    @Test
    public void case5() {
        ThirdSum obj = new ThirdSum();
        assertThat(obj.threeSum(new int[] { 1, -1, -1, 0 })).isEqualTo(List.of(
                List.of(-1,0,1)
        ));
    }
}
