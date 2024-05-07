// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

package data.structure.binary.tree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode tmp = root;

        while (tmp != null) {
            if (tmp.val == p.val || tmp.val == q.val) {
                return tmp;
            }

            if (tmp.val < p.val && tmp.val < q.val) {
                tmp = tmp.right;
            } else if (tmp.val > p.val && tmp.val > q.val) {
                tmp = tmp.left;
            } else {
                return tmp;
            }
        }

        return tmp;
    }
}
