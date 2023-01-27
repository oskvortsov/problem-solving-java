package data.structure.binary.tree;

import java.util.LinkedList;

public class MinimumDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int  depth = 1;
        int minimal = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int len  = queue.size();
            depth++;

            while (len != 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (node.left == null && node.right == null) minimal = Math.min(minimal, depth);
                len--;
            }
        }

        return minimal;
    }
}
