package topic.dynamic.programming;

import data.structure.binary.tree.TreeNode;

import java.util.List;

// https://leetcode.com/problems/all-possible-full-binary-trees/
public class AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return null;
        }

        return List.of();
    }
}
