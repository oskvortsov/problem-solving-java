package data.structure.binary.tree;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

public class KthSmallestElement {
    private int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        TreeNode res = inorder(root, k);
        return res != null ? res.val : -1;
    }

    public TreeNode inorder(TreeNode node, int k) {
        if (node == null) return null;

        TreeNode left = inorder(node.left, k);
        if (left != null) return left;

        if (k == ++index) return node;

        return inorder(node.right, k);
    }
}
