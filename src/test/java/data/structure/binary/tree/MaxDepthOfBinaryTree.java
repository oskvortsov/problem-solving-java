package data.structure.binary.tree;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/1158196127/

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return 1 + dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) return -1;
        return 1 + Math.max(dfs(node.left), dfs(node.right));
    }
}
