package data.structure.binary.tree;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// [3,9,20,null,null,15,7]
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int rootVal = postorder[postorder.length - 1];
        TreeNode node = new TreeNode(rootVal);
        return node;
    }
}
