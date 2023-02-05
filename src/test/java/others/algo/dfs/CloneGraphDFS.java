package others.algo.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CloneGraphDFS {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Node, Node> copyMap = new HashMap<>();
        proccessCopyNode(node, copyMap);

        return copyMap.get(node);
    }

    private void proccessCopyNode(Node root, HashMap<Node, Node> mapNodes) {
        Node copyNode = new Node(root.val);
        mapNodes.put(root, copyNode);

        for (Node node : root.neighbors) {
            if (!mapNodes.containsKey(node)) {
                proccessCopyNode(node, mapNodes);
            }
            copyNode.neighbors.add(mapNodes.get(node));
        }
    }
}
