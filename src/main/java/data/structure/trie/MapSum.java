package data.structure.trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MapSum {
    class Node {
        private int val;
        private final HashMap<Character, Node> children;

        Node() {
            children = new HashMap<>();
        }
    }

    private final Node root;

    public MapSum() {
        this.root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;

        for (char c: key.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Node());
            }

            cur = cur.children.get(c);
        }

        cur.val = val;
    }

    public int sum(String prefix) {
        Node cur = root;

        for (char c: prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return 0;
            }

            cur = cur.children.get(c);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(cur);
        int ans = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            ans += node.val;
            queue.addAll(node.children.values());
        }

        return ans;
    }
}
