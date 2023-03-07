package topic.binary.search;

import data.structure.binary.tree.TreeNode;

import java.util.*;

public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashSet<TreeNode> res = new HashSet<>();
        HashMap<Integer, List<TreeNode>> buffer = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

            List<TreeNode> list = buffer.getOrDefault(node.val, new ArrayList<>());

            boolean find = false;

            for (int i = 0; i < list.size(); i++) {
                TreeNode sib = list.get(i);

                if (compareTree(sib, node)) {
                    find = true;
                    res.add(sib);
                    break;
                }
            }

            if (!find) list.add(node);

            buffer.put(node.val, list);
        }

        return new ArrayList<>(res);
    }

    public boolean compareTree(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return a == null && b == null;
        }

        if (a.val != b.val) {
            return false;
        }

        return compareTree(a.left, b.left) && compareTree(a.right, b.right);
    }
}
