package data.structure.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> keys = new LinkedList<>();
        boolean[] opens = new boolean[rooms.size()];

        opens[0] = true;
        for (int key: rooms.get(0)) keys.add(key);

        while(!keys.isEmpty()) {
            int nextOpenRoom = keys.poll();
            opens[nextOpenRoom] = true;
            for (int key: rooms.get(nextOpenRoom)) {
                if (!opens[key]) {
                    keys.add(key);
                }
            }
        }

        for (boolean isOpen: opens) {
            if (!isOpen) return false;
        }

        return true;
    }
}
