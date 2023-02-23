package data.structure.binary.tree;

import java.util.*;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class SerializeАndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return "[]";
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                res.add(null);
            } else {
                res.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        while (res.get(res.size() - 1) == null) {
            res.remove(res.size() - 1);
        }

        return toString(res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Integer[] nums = fromString(data);

        if (nums.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> parents = new LinkedList<>();
        parents.add(root);

        int index = 0;
        int level = 1;

        while (index < nums.length) {
            int size = 1 << level++;

            for (int i = 0; i < size; i += 2) {
                TreeNode parent = parents.poll();
                if (parent == null) break;

                TreeNode left = index + 1 < nums.length && nums[index + 1] != null ? new TreeNode(nums[index + 1]) : null;
                TreeNode right = index + 2 < nums.length && nums[index + 2] != null ? new TreeNode(nums[index + 2]) : null;

                parent.left = left;
                parent.right = right;

                if (left != null) parents.add(left);
                if (right != null) parents.add(right);

                index += 2;
            }

        }


        return root;
    }

    private String toString(List<Integer> nums) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < nums.size(); i++) {
            sb.append(nums.get(i) == null ? "null" : nums.get(i));
            if (i != nums.size() - 1) sb.append(",");
        }
        sb.append("]");


        return sb.toString();
    }

    private Integer[] fromString(String data) {
        if (data.equals("[]")) {
            return new Integer[]{};
        }

        String[] nums = data.substring(1, data.length() - 1).split(",");
        Integer[] res = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i].equals("null") ? null : Integer.valueOf(nums[i]);
        }

        return res;
    }
}
