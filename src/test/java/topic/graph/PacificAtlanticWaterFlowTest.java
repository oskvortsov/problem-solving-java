package topic.graph;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PacificAtlanticWaterFlowTest {
    PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();

    @Test()
    public void case1() {
        int[][] edges = new int[][]{
                {0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}
        };


        // [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
        assertThat(obj.pacificAtlantic(
                new int[][] {
                        new int[] { 1,2,3,4 },
                        new int[] { 12,13,14,5 },
                        new int[] { 11,16,15,6 },
                        new int[] { 10,9,8,7 },
                }
        )).isEqualTo(List.of(
                List.of(0,3), List.of(1,0), List.of(1,1), List.of(1,2), List.of(1,3), List.of(2,0), List.of(2,1), List.of(2,2), List.of(2,3), List.of(3,0), List.of(3,1), List.of(3,2), List.of(3,3)
        ));
    }
}
