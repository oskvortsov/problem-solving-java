package topic.graph;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LargestColorValueInADirectedGraphTest {
    LargestColorValueInADirectedGraph obj = new LargestColorValueInADirectedGraph();

    @Test()
    public void case1() {
        assertThat(obj.largestPathValue("abaca", new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}})).isEqualTo(3);
    }

    @Test()
    public void case2() {
        assertThat(obj.largestPathValue("abc", new int[][]{{0, 1}, {1, 2}, {2, 0}})).isEqualTo(-1);
    }

    @Test()
    public void case3() {
        assertThat(obj.largestPathValue("a", new int[][]{{0, 0}})).isEqualTo(-1);
    }

    @Test()
    public void case4() {
        assertThat(obj.largestPathValue("hhqhuqhqff", new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}, {3, 5}, {5, 6}, {2, 7}, {6, 7}, {7, 8}, {3, 8}, {5, 8}, {8, 9}, {3, 9}, {6, 9}})).isEqualTo(3);
    }

    @Test()
    public void case6() {
        assertThat(obj.largestPathValue("ab", new int[][]{{0, 1}, {1 , 1}})).isEqualTo(-1);
    }

    @Test()
    public void case7() {
        assertThat(obj.largestPathValue("aaa", new int[][]{{1, 2}, {2 , 1}})).isEqualTo(-1);
    }
}

