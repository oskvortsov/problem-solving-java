package data.structure.binary.tree;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConstructBinaryTreeFromInorderAndPostorderTraversalTest {
    ConstructBinaryTreeFromInorderAndPostorderTraversal obj = new ConstructBinaryTreeFromInorderAndPostorderTraversal();

    @Test()
    public void case1() {
        TreeNode tree = obj.buildTree(
                new int[] { 9,3,15,20,7 },
                new int[] { 9,15,7,20,3 }
        );
        assertThat(tree).isNotNull();
    }
}

