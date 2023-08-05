package topic.array;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[][] sortedSpell = new int[spells.length][2];

        for (int i = 0; i < spells.length; i++) {
            sortedSpell[i][0] = spells[i];
            sortedSpell[i][1] = i;
        }
        Arrays.sort(sortedSpell, (a, b) -> a[0] - b[0]);
        int[] res = new int[spells.length];
        int potionIndex = potions.length - 1;

        for (int i = 0; i < sortedSpell.length; i++) {
            int spell = sortedSpell[i][0];
            int index = sortedSpell[i][1];

            while (potionIndex >= 0 && (long) spell * potions[potionIndex] > success) {
                potionIndex--;
            }

            res[index] = potions.length - potionIndex - 1;
        }


        return res;
    }

    public int[] successfulPairs1(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[] res = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long minPortion = (long) Math.ceil((1.0 * success) / spells[i]);
            if ((long) potions[potions.length - 1] * spells[i] < minPortion) {
                res[i] = 0;
            } else {
                res[i] = potions.length - binarySearch(0, potions.length, potions, minPortion);
            }
        }

        return res;
    }

    private int binarySearch(int l, int r, int[] arr, float target) {
        while (l < r) {
            int mid = l + (r - l ) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r;
    }
}
