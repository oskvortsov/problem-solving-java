package data.structure.binary.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinarySearchTreeToGreaterSumTree {
    int accSym;

    public TreeNode bstToGst(TreeNode root) {
        accSym = 0;
        reverseTraverseInOrder(root);
        return root;
    }

    public void reverseTraverseInOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        reverseTraverseInOrder(node.right);
        node.val += accSym;
        accSym = node.val;

        reverseTraverseInOrder(node.left);
    }

    public TreeNode bstToGst1(TreeNode root) {
        HashMap<Integer, TreeNode> nodesByIndex = new HashMap<>();
        List<Integer> prefixSum = new ArrayList<>();

        traverInOrder(root, nodesByIndex, prefixSum);

        int max = prefixSum.get(prefixSum.size() - 1);

        for (int i = 0; i < prefixSum.size(); i++) {
            nodesByIndex.get(i).val += max - prefixSum.get(i);
        }

        return root;
    }

    public void traverInOrder(TreeNode node, HashMap<Integer, TreeNode> nodesByIndex, List<Integer> prefixSum) {
        if (node == null) {
            return;
        }

        traverInOrder(node.left, nodesByIndex, prefixSum);

        int index = prefixSum.size();
        nodesByIndex.put(index, node);
        prefixSum.add(index > 0 ? prefixSum.get(index - 1) + node.val : node.val);

        traverInOrder(node.right, nodesByIndex, prefixSum);
    }

}
