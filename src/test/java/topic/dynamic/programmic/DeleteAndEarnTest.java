package topic.dynamic.programmic;

import org.junit.Test;
import topic.dynamic.programming.DeleteAndEarn;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DeleteAndEarnTest {
    @Test()
    public void case1() {
        DeleteAndEarn obj = new DeleteAndEarn();

        assertThat(obj.deleteAndEarn(new int[] { 3,4,2 })).isEqualTo(6);
        assertThat(obj.deleteAndEarn(new int[] { 3,4,2,5 })).isEqualTo(8);
        assertThat(obj.deleteAndEarn(new int[] { 2,2,3,3,3,4 })).isEqualTo(9);
        assertThat(obj.deleteAndEarn(new int[] { 1,1,1,2,4,5,5,5,6 })).isEqualTo(18);
    }
}
