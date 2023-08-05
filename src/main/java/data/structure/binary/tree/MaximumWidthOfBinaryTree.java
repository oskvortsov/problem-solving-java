package data.structure.binary.tree;

import java.util.*;

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        root.val = 0;

        int width = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            int L = Integer.MAX_VALUE;
            int R = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                L = Math.min(L, node.val);
                R = Math.max(R, node.val);

                if (node.left != null) {
                    node.left.val = 2 * node.val + 1;
                    q.add(node.left);
                }

                if (node.right != null) {
                    node.right.val = 2 * node.val + 2;
                    q.add(node.right);
                }
            }

            width = Math.max(width, Math.abs(R - L) + 1);
        }


        return width;
    }
}
