package topic.linked.list;

import java.util.HashMap;

// https://leetcode.com/problems/lru-cache/submissions/

public class LRUCache {
    private static class Node {
        Node left;
        Node right;
        int key;
        int value;

        Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    private final HashMap<Integer, Node> map;
    private final int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            popup(node);

            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            popup(node);
        } else {
            Node node = new Node(key, value);
            insert(node);
        }
    }

    private void insert(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.left = node;
            node.right = head;
            head = node;
        }

        map.put(node.key, node);

        if (map.size() > capacity) {
            erase();
        }
    }

    private void popup(Node node) {
        // is already head
        if (head == node) return;

        // is tail element
        if (node == tail) {
            // change previous
            node.left.right = null;
            tail = node.left;
            node.left = null;

            // change head
            head.left = node;
            node.right = head;
            head = node;
            return;
        }

        // between two nodes
        node.left.right = node.right;
        node.right.left = node.left;
        head.left = node;
        node.right = head;
        node.left = null;
        head = node;
    }

    private void erase() {
        map.remove(tail.key);

        if (tail.left != null) {
            tail.left.right = null;
        }

        tail = tail.left;
    }
}
