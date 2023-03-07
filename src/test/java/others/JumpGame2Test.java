package others;

import org.junit.Test;
import topic.dynamic.programming.JumpGame2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JumpGame2Test {
    @Test()
    public void case1() {
        JumpGame2 jg2 = new JumpGame2();
        assertThat(jg2.jump(new int[] { 1, 2, 3 })).isEqualTo(2);
        assertThat(jg2.jump(new int[] { 2,3,1,1,4 })).isEqualTo(2);
        assertThat(jg2.jump(new int[] { 2,3,0,1,4 })).isEqualTo(2);
        assertThat(jg2.jump(new int[] { 0 })).isEqualTo(0);
        assertThat(jg2.jump(new int[] { 1 })).isEqualTo(0);
    }
}
