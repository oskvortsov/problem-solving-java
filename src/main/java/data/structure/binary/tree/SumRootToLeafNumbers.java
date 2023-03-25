package data.structure.binary.tree;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return traverse(root, 0);
    }

    private int traverse(TreeNode node, int cur) {
        if (node == null) return 0;

        cur = cur * 10 + node.val;

        if (node.left == null && node.right == null) {
            return cur;
        }

        return traverse(node.left, cur) + traverse(node.right, cur);
    }
}
