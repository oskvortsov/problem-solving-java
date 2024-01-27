package data.structure.binary.tree;

// https://leetcode.com/problems/diameter-of-binary-tree/description/

public class DiameterOfBinaryTree {
    private int diameter = 0;

    private int dfs(TreeNode node) {
        if (node == null) return -1;

        int left = dfs(node.left);
        int right =  dfs(node.right);

        diameter = Math.max(left + right + 2, diameter);

        return 1 + Math.max(left, right);
    }

    private int maxDepth(TreeNode node, int depth) {
        if (node == null) return depth - 1;

        int left = maxDepth(node.left, depth + 1);
        int right =  maxDepth(node.right, depth + 1);

        diameter = Math.max(
                left + right - 2 * depth,
                diameter
        );

        return Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
//        if (root == null) return 0;

//        maxDepth(root, 0);
        dfs(root);

        return diameter;
    }
}
