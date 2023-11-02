package topic.binary.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore {
    private class Node {
        private final String value;
        private final int timestamp;

        Node(String v, int t) {
            value = v;
            timestamp = t;
        }
    }

    HashMap<String, List<Node>> store;

    public TimeBasedKeyValueStore() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Node> list = store.getOrDefault(key, new ArrayList<>());
        list.add(new Node(value, timestamp));
        list.sort(Comparator.comparingInt((Node a) -> a.timestamp));

        store.put(key, list);
    }

    public String get(String key, int timestamp) {
        if (store.isEmpty() || !store.containsKey(key)) {
            return "";
        }

        List<Node> list = store.get(key);

        int l = 0, r = list.size() - 1;

        if (timestamp < list.get(l).timestamp) return "";
        if (timestamp >= list.get(r).timestamp) return list.get(r).value;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (timestamp == list.get(mid).timestamp) {
                return list.get(mid).value;
            }

            if (timestamp > list.get(l).timestamp) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (r > -1) return list.get(r).value;

        return "";
    }
}
