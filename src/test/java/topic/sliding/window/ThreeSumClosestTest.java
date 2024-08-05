package topic.sliding.window;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeSumClosestTest {
    @Test
    public void case1() {
        ThreeSumClosest obj = new ThreeSumClosest();
        assertThat(obj.threeSumClosest(new int[] { 4,0,5,-5,3,3,0,-4,-5 }, -2)).isEqualTo(-2);
    }

    @Test
    public void case2() {
        ThreeSumClosest obj = new ThreeSumClosest();
        assertThat(obj.threeSumClosest(new int[] { 1,1,1,0 }, -100)).isEqualTo(2);
    }
}
