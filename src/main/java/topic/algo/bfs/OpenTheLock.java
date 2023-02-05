package topic.algo.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        LinkedList<String> queue = new LinkedList();
        int step = 0;

        queue.add("0000");

        if (deadendsSet.contains("0000")) {
            return -1;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String slot = queue.pop();

                if (slot.equals(target)) {
                    return step;
                }

                ArrayList<String> list = generateNewSteps(slot);
                for (String newSlot : list) {
                    if (!visited.contains(newSlot) && !deadendsSet.contains(newSlot)) {
                        queue.add(newSlot);
                        visited.add(newSlot);
                    }
                }
            }

            step++;
        }

        return -1;
    }

    private ArrayList<String> generateNewSteps(String base) {
        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int slot = Character.getNumericValue(base.charAt(i));
            int prev = slot == 0 ? 9 : slot - 1;
            int next = slot == 9 ? 0 : slot + 1;

            StringBuilder prevSlot = new StringBuilder(base);
            prevSlot.setCharAt(i, Character.forDigit(prev, 10));

            StringBuilder nextSlot = new StringBuilder(base);
            nextSlot.setCharAt(i, Character.forDigit(next, 10));

            res.add(prevSlot.toString());
            res.add(nextSlot.toString());
        }

        return res;
    }

    public static void main(String[] args) {
        OpenTheLock obj = new OpenTheLock();
        System.out.println(obj.openLock(new String[] { "8887","8889","8878","8898","8788","8988","7888","9888" }, "8888"));
    }
}
