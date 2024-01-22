package topic.binary.search;

import data.structure.binary.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();

        traverse(root, list);

        for (int i = 1; i < list.size(); i++) {
            min = Math.min(list.get(i) - list.get(i - 1), min);
        }

        return min;
    }

    private void traverse(TreeNode node, List list) {
        if (node == null) return;

        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }
}
