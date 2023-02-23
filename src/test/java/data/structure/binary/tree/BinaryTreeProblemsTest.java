package data.structure.binary.tree;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BinaryTreeProblemsTest {
    @Test()
    public void minDiffInBSTCase1() {
        BinaryTreeProblems btp = new BinaryTreeProblems();
        TreeNode input = new TreeNode(
                4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6)
        );

        assertThat(btp.minDiffInBST(input)).isEqualTo(1);
    }

    @Test()
    public void constructMaximumBinaryTree() {
        int[] input = new int[] { 3,2,1,6,0,5 };
        TreeNode output = new TreeNode(
                6,
                new TreeNode(3, null, new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(5, new TreeNode(0), null)
        );

        BinaryTreeProblems btp = new BinaryTreeProblems();
        assertThat(btp.constructMaximumBinaryTree(input)).isEqualToComparingFieldByField(output);
    }
}

