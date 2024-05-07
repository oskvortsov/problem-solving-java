package data.structure.binary.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://leetcode.com/problems/validate-binary-search-tree/

public class ValidateBinarySearchTree {
    private TreeNode prev;

    public boolean isValidBST(TreeNode root) {
         return inorder(root);
    }

    private boolean inorder(TreeNode node) {
        if (node == null) return true;

        if (!inorder(node.left)) {
            return false;
        }

        if (prev != null && prev.val > node.val) {
            System.out.println(prev.val);
            return false;
        }

        prev = node;

        return inorder(node.right);
    }



}

