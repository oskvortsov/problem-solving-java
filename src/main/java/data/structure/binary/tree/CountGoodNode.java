package data.structure.binary.tree;

// https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
public class CountGoodNode {
    public int goodNodes(TreeNode root) {
        return search(root, root.val);
    }

    private int search(TreeNode node, int max) {
        if (node == null) return 0;

        int count = 0;

        if (node.val >= max) {
            count++;
            max = node.val;
        }

        count += search(node.left, max);
        count += search(node.right, max);

        return count;
    }
}
