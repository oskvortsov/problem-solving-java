package topic.tree;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConstructQuadTreeTest {
    ConstructQuadTree obj = new ConstructQuadTree();

//    @Test()
//    public void case1() {
//        ConstructQuadTree.Node tree = obj.construct(new int[][]{{0, 1}, {1, 0}});
//        assertThat(tree).isNotNull();
//    }

    @Test()
    public void case2() {
        ConstructQuadTree.Node tree = obj.construct(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
        });
        assertThat(tree).isNotNull();
    }

    @Test()
    public void case3() {
        ConstructQuadTree.Node tree = obj.construct(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}
        });
        assertThat(tree).isNotNull();
    }
}

