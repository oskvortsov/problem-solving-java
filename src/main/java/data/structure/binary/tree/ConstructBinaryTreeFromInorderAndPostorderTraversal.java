package data.structure.binary.tree;

import java.util.Arrays;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// [3,9,20,null,null,15,7]
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return process(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTreeByIndex(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length || inorder.length == 0) {
            return null;
        }

        idx = postorder.length-1;
        return build(inorder, postorder, 0, idx);
    }

    private TreeNode buildByCopyArray(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }

        int root = postorder[postorder.length - 1];

        TreeNode node = new TreeNode(root);

        if (postorder.length == 1) {
            return node;
        }

        int inorderRoot = 1;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                inorderRoot = i;
                break;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, inorderRoot);
        int[] rightInorder = Arrays.copyOfRange(inorder, inorderRoot + 1, inorder.length);

        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, inorderRoot);
        int[] rightPostorder = Arrays.copyOfRange(postorder, inorderRoot, postorder.length - 1);

        node.left = buildByCopyArray(leftInorder, leftPostorder);
        node.right = buildByCopyArray(rightInorder, rightPostorder);

        return node;
    }

    public TreeNode process(int[] inorder, int[] postorder, int inStr, int inEnd, int posStr, int posEnd) {
        if (posStr > posEnd) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[posEnd]);

        if (posEnd == posStr) {
            return node;
        }

        int iIndex = 0;

        for (int i = inStr; i <= inEnd; i++) {
            if (inorder[i] == node.val) {
                iIndex = i;
                break;
            }
        }

        node.left = process(inorder, postorder, inStr, iIndex - 1, posStr, posStr + (iIndex - inStr - 1));
        node.right = process(inorder, postorder, iIndex + 1, inEnd, posStr + iIndex - inStr, posEnd - 1);

        return node;
    }


    private TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start>end) return null;
        TreeNode node = new TreeNode(postorder[idx--]);
        if (start==end) return node;

        int index = findIdx(inorder, node.val, end);
        node.right = build(inorder, postorder, index+1, end);
        node.left = build(inorder, postorder, start, index-1);
        return node;
    }

    private int findIdx(int[] inorder, int val, int end) {
        for (int i=end; i>=0; i--) {
            if (inorder[i]==val) return i;
        }
        return 0;
    }
}
