package data.structure.binary.tree;

import java.util.*;

public class BinaryTreeProblems {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int  depth = 1;
        int minimal = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int len  = queue.size();
            depth++;

            while (len != 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (node.left == null && node.right == null) minimal = Math.min(minimal, depth);
                len--;
            }
        }

        return minimal;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            while (size-- > 0) {
                TreeNode node = queue.poll();

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return depth;
    }

    public int minDiffInBST(TreeNode root) {
        Stack<TreeNode> queue = new Stack<>();
        int min = Integer.MAX_VALUE;
        TreeNode node = root;
        Queue<Integer> stack = new LinkedList<>();


        while (!queue.isEmpty() || node != null) {
            if (node != null) {
                queue.add(node);
                node = node.left;
            } else {
                node = queue.pop();
                stack.add(node.val);
                node = node.right;
            }

            if (stack.size() > 1) {
                min = Math.min(
                        Math.abs(stack.poll() - stack.peek()),
                        min
                );
            }
        }

        return min;
    }


    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int curDepthSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                curDepthSum += node.val;
            }

            sum = curDepthSum;
        }

        return sum;
    }


    // 3,2,1,6,0,5
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = buildTree(nums, 0, nums.length - 1);
        return root;
    }

    TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int max = l;

        for (int i = l; i <= r; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }

        TreeNode node = new TreeNode(nums[max]);
        node.left = buildTree(nums, l, max - 1);
        node.right = buildTree(nums, max + 1, r);

        return node;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        boolean isForward = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (isForward) levelList.addLast(node.val);
                else levelList.addFirst(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            isForward = !isForward;
            res.add(levelList);
        }

        return res;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode L = queue.poll();
            TreeNode R = queue.poll();

            if (L == null && R == null) continue;
            if (L == null || R == null) return false;
            if (L.val != R.val) return false;

            queue.add(L.left);
            queue.add(R.right);

            queue.add(L.right);
            queue.add(R.left);
        }

        return true;
    }
}
