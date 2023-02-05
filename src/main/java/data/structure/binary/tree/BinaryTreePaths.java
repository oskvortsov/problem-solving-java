package data.structure.binary.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        procces(root, ans, new StringBuffer());

        return ans;
    }

    private void procces(TreeNode node, List<String> ans, StringBuffer path) {
        if (node == null) {
            return;
        }

        if (path.length() != 0) path.append("->");
        path.append(node.val);

        if (node.left == null && node.right == null) {
            ans.add(path.toString());
            return;
        }

        procces(node.left, ans, new StringBuffer(path));
        procces(node.right, ans, new StringBuffer(path));
    }
}
