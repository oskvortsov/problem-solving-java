package data.structure.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
public class SumOfNodesWithEvenValuedGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val % 2 == 0) res += sumGrandChildren(node);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return res;
    }

    private int sumGrandChildren(TreeNode node) {
        int sum = 0;

        if (node.left != null) {
            sum += node.left.left != null ? node.left.left.val : 0;
            sum += node.left.right != null ? node.left.right.val : 0;
        }

        if (node.right != null) {
            sum += node.right.left != null ? node.right.left.val : 0;
            sum += node.right.right != null ? node.right.right.val : 0;
        }

        return sum;
    }
}
