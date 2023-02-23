package data.structure.binary.tree;

public class BinaryTreeMinDiffBST {
    int minDistance = Integer.MIN_VALUE;
    TreeNode prev = null;

    public int minDiffInBST(TreeNode root) {
        inorderTraversal(root);

        return minDistance;
    }

    public void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        if (prev != null) {
            minDistance = Math.min(
                    minDistance,
                    Math.abs(node.val - prev.val)
            );
        }

        prev = node;

        inorderTraversal(node.right);
    }

}
