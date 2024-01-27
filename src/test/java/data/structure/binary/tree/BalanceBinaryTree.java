package data.structure.binary.tree;

// https://leetcode.com/problems/balanced-binary-tree/description/
public class BalanceBinaryTree {
    private boolean isBalanced = true;

    int dfs(TreeNode node) {
        if (node == null) return - 1;

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (Math.abs(left - right) >= 2) {
            isBalanced = false;
        }

        return 1 + Math.max(left, right);

    }

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }
}
