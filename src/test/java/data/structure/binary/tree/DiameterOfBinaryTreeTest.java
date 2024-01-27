package data.structure.binary.tree;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiameterOfBinaryTreeTest {
    @Test
    public void case1() {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3)
        );

        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
        assertThat(obj.diameterOfBinaryTree(root)).isEqualTo(3);
    }
}
