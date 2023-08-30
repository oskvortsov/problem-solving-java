package topic.dynamic.programmic;

import org.junit.Test;
import topic.dynamic.programming.HouseRobber;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HouseRobberTest {
    @Test()
    public void case1() {
        HouseRobber obj = new HouseRobber();

        assertThat(obj.rob(new int[] { 1,2,3,1 })).isEqualTo(4);
        assertThat(obj.rob(new int[] { 2,7,9,3,1 })).isEqualTo(12);
    }
}

