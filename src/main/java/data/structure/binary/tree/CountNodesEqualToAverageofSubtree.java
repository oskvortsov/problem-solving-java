package data.structure.binary.tree;

// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
public class CountNodesEqualToAverageofSubtree {
    public int averageOfSubtree(TreeNode root) {
        return 1;
    }

    private int[] traverse(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0};
        }

        int[] left = traverse(node.left);
        int[] right = traverse(node.right);

        return left;
    }
}
