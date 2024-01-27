package data.structure.binary.tree;

public class SubtreeOfAnotherTree {
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private boolean dfs(TreeNode node, TreeNode subTree) {
        if (node == null) return false;
        return isSameTree(node, subTree) || dfs(node.left, subTree) || dfs(node.right, subTree);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }
}
