package data.structure.binary.tree;

// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/

public class LongestZigZagPathInABinaryTree {
    public int longestZigZag(TreeNode root) {
        return Math.max(
                countZigZat(root.left, true, 0),
                countZigZat(root.right, false, 0)
        );
    }

    int countZigZat(TreeNode node, boolean isLeft, int count) {
        if (node == null) {
            return count;
        }

        count++;

        return Math.max(
                Math.max(countZigZat(node.left, true, !isLeft ? count : 0), count),
                Math.max(countZigZat(node.right, false, isLeft ? count : 0), count)
        );
    }
}
