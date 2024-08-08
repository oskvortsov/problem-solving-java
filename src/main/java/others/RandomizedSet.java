package others;

import java.util.Arrays;
import java.util.HashMap;

public class RandomizedSet {
    private final HashMap<Integer, Integer> indexMap;
    private int[] data;
    int index, size;

    public RandomizedSet() {
        indexMap = new HashMap<>();
        size = 10;
        data = new int[size];
        index = 0;
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }

        if (index == size - 1) malloc();
        indexMap.put(val, index);
        data[index++] = val;

        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }

        var deleteIndex = indexMap.get(val);
        indexMap.remove(val);
        data[deleteIndex] = data[--index];

        if (deleteIndex != index) {
            indexMap.put(data[deleteIndex], deleteIndex);
        }

        return true;
    }

    public int getRandom() {
        int randomIndex = (int) (Math.random() * index);
        return data[randomIndex];
    }

    private void malloc() {
        size *= 2;
        data = Arrays.copyOf(data, size);
    }
}
