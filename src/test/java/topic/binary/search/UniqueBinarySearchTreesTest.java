package topic.binary.search;

import data.structure.binary.tree.UniqueBinarySearchTrees;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UniqueBinarySearchTreesTest {
    @Test
    public void case1() {
        UniqueBinarySearchTrees obj = new UniqueBinarySearchTrees();
        assertThat(obj.numTrees(1)).isEqualTo(1);
        assertThat(obj.numTrees(2)).isEqualTo(2);
        assertThat(obj.numTrees(3)).isEqualTo(5);
        assertThat(obj.numTrees(4)).isEqualTo(14);
        assertThat(obj.numTrees(5)).isEqualTo(42);
        assertThat(obj.numTrees(6)).isEqualTo(132);
    }
}
