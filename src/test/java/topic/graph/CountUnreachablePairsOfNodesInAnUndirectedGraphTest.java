package topic.graph;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CountUnreachablePairsOfNodesInAnUndirectedGraphTest {
    @Test()
    public void case1() {
        CountUnreachablePairsOfNodesInAnUndirectedGraph obj = new CountUnreachablePairsOfNodesInAnUndirectedGraph();
        int[][] edges = new int[][]{
                {5, 0}, {1, 0}, {10, 7}, {9, 8}, {7, 2}, {1, 3}, {0, 2}, {8, 5}, {4, 6}, {4, 2}
        };
        assertThat(obj.countPairs(11, edges)).isEqualTo(0);
    }

    @Test()
    public void case2() {
        CountUnreachablePairsOfNodesInAnUndirectedGraph obj = new CountUnreachablePairsOfNodesInAnUndirectedGraph();
        int[][] edges = new int[][] {};
        assertThat(obj.countPairs(100000, edges)).isEqualTo(4999950000L);
    }
}
