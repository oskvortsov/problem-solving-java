package topic.graph;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LongestCycleInAGraphTest {
    @Test()
    public void case1() {
        LongestCycleInAGraph obj = new LongestCycleInAGraph();

        assertThat(obj.longestCycle(new int[] { 3,3,4,2,3 })).isEqualTo(3);
    }

    @Test()
    public void case2() {
        LongestCycleInAGraph obj = new LongestCycleInAGraph();

        assertThat(obj.longestCycle(new int[] { 1,2,0,4,5,6,3,8,9,7 })).isEqualTo(4);
    }

    @Test()
    public void case3() {
        LongestCycleInAGraph obj = new LongestCycleInAGraph();

        assertThat(obj.longestCycle(new int[] { -1,4,-1,2,0,4 })).isEqualTo(-1);
    }

    @Test()
    public void case4() {
        LongestCycleInAGraph obj = new LongestCycleInAGraph();

        assertThat(obj.longestCycle(new int[] { 49,29,24,24,-1,-1,-1,2,23,-1,44,47,52,49,9,31,40,34,-1,53,33,-1,2,-1,18,31,0,9,47,35,-1,-1,-1,-1,4,12,14,19,-1,4,4,43,25,11,54,-1,25,39,17,-1,22,44,-1,44,29,50,-1,-1 })).isEqualTo(-1);
    }

}

