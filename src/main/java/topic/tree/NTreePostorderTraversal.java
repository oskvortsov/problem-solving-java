package topic.tree;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

// https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
public class NTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);

        return result;
    }

    private void postorder(Node root, List<Integer> list) {
       if (root == null) return;

       for (Node child : root.children) {
           postorder(child, list);
       }

       list.add(root.val);
    }
}
