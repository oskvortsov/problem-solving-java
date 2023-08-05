package data.structure.binary.tree;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MaximumWidthOfBinaryTreeTest {
    @Test()
    public void case1() {
        MaximumWidthOfBinaryTree obj = new MaximumWidthOfBinaryTree();
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, null,  new TreeNode(5))
        );
        assertThat(obj.widthOfBinaryTree(node)).isEqualTo(4);
    }

    @Test()
    public void case2() {
        MaximumWidthOfBinaryTree obj = new MaximumWidthOfBinaryTree();
        TreeNode node = new TreeNode(
                1,
                new TreeNode(0, new TreeNode(0, new TreeNode(0), null), null),
                new TreeNode(3, null,  new TreeNode(5, new TreeNode(0), null)
            )
        );
        assertThat(obj.widthOfBinaryTree(node)).isEqualTo(7);
    }
}
