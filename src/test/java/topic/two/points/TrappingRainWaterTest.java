package topic.two.points;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrappingRainWaterTest {
    @Test
    public void case1() {
        TrappingRainWater obj = new TrappingRainWater();
        assertThat(obj.trap(new int[] { 0,1,0,2,1,0,1,3,2,1,2,1 })).isEqualTo(6);
    }

    @Test
    public void case2() {
        TrappingRainWater obj = new TrappingRainWater();
        assertThat(obj.trap(new int[] { 4,2,0,3,2,5 })).isEqualTo(9);
    }

    @Test
    public void case3() {
        TrappingRainWater obj = new TrappingRainWater();
        assertThat(obj.trap(new int[] { 4,2,3 })).isEqualTo(1);
    }

    @Test
    public void case5() {
        TrappingRainWater obj = new TrappingRainWater();
        assertThat(obj.trap(new int[] {9,8,2,6 })).isEqualTo(4);
    }
}
