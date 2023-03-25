package topic.graph;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MinimumTimeToCollectAllApplesInATreeTest {
    MinimumTimeToCollectAllApplesInATree obj = new MinimumTimeToCollectAllApplesInATree();

    @Test()
    public void case1() {
        int[][] edges = new int[][]{
                {0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}
        };


        assertThat(obj.minTime(7, edges, List.of(false,false,true,false,true,true,false))).isEqualTo(8);
    }

    @Test()
    public void case2() {
        int[][] edges = new int[][]{
                {0, 2}, {0, 3}, {1, 2}
        };


        assertThat(obj.minTime(7, edges, List.of(false,false,true,false,true,true,false))).isEqualTo(8);
    }
}

