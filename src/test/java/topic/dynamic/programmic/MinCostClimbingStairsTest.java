package topic.dynamic.programmic;
import org.junit.Test;
import topic.dynamic.programming.MinCostClimbingStairs;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MinCostClimbingStairsTest {
    @Test()
    public void case1() {
        MinCostClimbingStairs minCost = new MinCostClimbingStairs();
//        assertThat(minCost.minCostClimbingStairs(new int[] { 1,100,1,1,1,100,1,1,100,1 })).isEqualTo(6);
        assertThat(minCost.minCostClimbingStairs(new int[] { 10, 15, 20 })).isEqualTo(15);
    }
}

