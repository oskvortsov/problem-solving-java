package data.structure.binary.tree;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LowestCommonAncestorTest {
    @Test
    public void case1() {
        LowestCommonAncestor obj = new LowestCommonAncestor();
        TreeNode tree = new TreeNode(
                6,
                new TreeNode(
                        2,
                        null,
                        new TreeNode(4, new TreeNode(3), new TreeNode(5))
                ),
                null
        );
        TreeNode lcs = obj.lowestCommonAncestor(tree, new TreeNode(3), new TreeNode(5));

        assertThat(lcs.val).isEqualTo(4);
    }
}
