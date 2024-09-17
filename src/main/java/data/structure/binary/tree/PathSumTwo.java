package data.structure.binary.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumTwo {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(root, targetSum, answer, new ArrayList<>());
        return answer;
    }

    private void dfs(TreeNode node, int target, List<List<Integer>> res, List<Integer> cur) {
        if (node == null || target < 0) return;

        cur.add(node.val);

        if (node.left == null && node.right == null) {
            if (node.val == target) res.add(new ArrayList<>(cur));
        } else {
            dfs(node.left, target - node.val, res, cur);
            dfs(node.right, target - node.val, res, cur);
        }

        cur.remove(cur.size() - 1);
    }
}
