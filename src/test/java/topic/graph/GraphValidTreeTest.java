package topic.graph;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GraphValidTreeTest {
    @Test()
    public void case1() {
        GraphValidTree obj = new GraphValidTree();

        // [[0,1],[2,0],[3,0],[1,4]]
        assertThat(obj.validTree(5, new int[][] {
                new int[] { 0, 1},
                new int[] { 2, 0},
                new int[] { 3, 0},
                new int[] { 1, 4},
        })).isTrue();
    }
}
