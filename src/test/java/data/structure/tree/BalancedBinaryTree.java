package data.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return balanceHeight(root) != -1;
    }

    public int balanceHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftTree = balanceHeight(node.left);
        if (leftTree == -1) {
            return -1;
        }

        int rightTree = balanceHeight(node.right);
        if (rightTree == -1) {
            return -1;
        }

        if (Math.abs(leftTree - rightTree) > 1) {
            return -1;
        }

        return Math.max(leftTree, rightTree) + 1;
    }
}
