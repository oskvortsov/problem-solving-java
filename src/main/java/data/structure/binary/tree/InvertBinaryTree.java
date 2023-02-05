package data.structure.binary.tree;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        swapList(root);
        return root;
    }

    public void swapList(TreeNode node) {
        if (node == null || node.left == node.right) {
            return;
        }

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        swapList(node.left);
        swapList(node.right);
    }
}
