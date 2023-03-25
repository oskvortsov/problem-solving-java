package data.structure.binary.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidateBinarySearchTree {
    private TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }

        return inorderValid(root);
    }

    public boolean isValidBST1(TreeNode node)  {
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty()  || node != null) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (prev != null && prev.val >= node.val) {
                    return false;
                }

                prev = node;
                node = node.right;
            }
        }

        return true;
    }

    public boolean inorderValid(TreeNode node) {
        if (node == null) return true;

        if (!inorderValid(node.left)) {
            return false;
        }

        if (prev != null && prev.val >= node.val) {
            return false;
        }

        prev = node;

        return inorderValid(node.right);
    }
}

