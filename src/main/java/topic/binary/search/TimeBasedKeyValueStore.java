package topic.binary.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore {
    private static class Node {
        private final int timestamp;
        private final String value;

        Node(int t, String v) {
            timestamp = t;
            value = v;
        }
    }

    private final HashMap<String, List<Node>> store;

    public TimeBasedKeyValueStore() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Node node = new Node(timestamp, value);
        List<Node> list = store.getOrDefault(key, new ArrayList<>());
        list.add(node);

        store.put(key, list);
    }

    public String get(String key, int timestamp) {
        String res = "";

        if (store.isEmpty() || !store.containsKey(key)) {
            return res;
        }

        List<Node> list = store.get(key);
        int l = 0, r = list.size() - 1;

        if (list.get(l).timestamp > timestamp) {
            return res;
        }

        if (list.get(r).timestamp <= timestamp) {
            return list.get(r).value;
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            Node node = list.get(mid);

            if (node.timestamp == timestamp) {
                res = node.value;
                break;
            }

            if (node.timestamp < timestamp) {
                res = node.value;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }
}
