package topic.dynamic.programmic;

import org.junit.Test;
import topic.dynamic.programming.JumpGame;

import static org.assertj.core.api.Assertions.assertThat;

public class JumpGameTest {
    @Test
    public void case1() {
        JumpGame obj = new JumpGame();
        assertThat(obj.canJump(new int[] { 2,3,1,1,4 })).isEqualTo(true);
    }
}
