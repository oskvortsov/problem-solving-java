package topic.array;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        int hIndex = 0, size = citations.length;
        Arrays.sort(citations);

        for (int idx = size - 1; idx > -1; idx--) {
            if (citations[idx] > hIndex) hIndex++;
            else break;
        }

        return hIndex;
    }
}
