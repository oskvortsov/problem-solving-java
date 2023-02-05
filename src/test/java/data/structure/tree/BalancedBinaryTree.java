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

//    public boolean isBalanced(TreeNode root) {
//
//    }
//
//    public boolean deep(TreeNode node) {
//
//    }
}
