package data.structure.binary.tree;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private HashMap<Integer, Integer> inOrderPosition;
    private int  idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = 0;
        inOrderPosition = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) inOrderPosition.put(inorder[i], i);
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[idx++]);

        if (start == end) {
            return node;
        }

        int iIndex = inOrderPosition.get(node.val);

        node.left = build(preorder, inorder, start, iIndex - 1);
        node.right = build(preorder, inorder, iIndex + 1, end);

        return node;
    }
}
