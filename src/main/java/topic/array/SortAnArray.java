package topic.array;

// https://leetcode.com/problems/sort-an-array/description/
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        return mergeSort(0, nums.length - 1, nums);
    }

    public void quickSort(int l, int r, int[] arr) {
        if (l < r) {
            int pi = partition(l, r, arr);
            quickSort(l, pi - 1, arr);
            quickSort(pi + 1, r, arr);
        }
    }

    public int partition(int l, int r, int[] arr) {
        int i = l - 1;
        int pivot = arr[r];

        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                swap(++i, j, arr);
            }
        }

        swap(++i, r, arr);

        return i;
    }

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] mergeSort(int l, int r, int[] nums) {
        if (r >= nums.length || r == l) {
            return new int[] { nums[l] };
        }

        int mid = l + (r - l) / 2;

        int[] left = mergeSort(l, mid, nums);
        int[] right = mergeSort(mid + 1, r, nums);

        int lIndex = 0;
        int rIndex = 0;

        int[] res = new int[r - l + 1];

        for (int i = 0; i < res.length; i++) {
            if (rIndex >= right.length || lIndex < left.length && left[lIndex] < right[rIndex]) {
                res[i] = left[lIndex++];
            } else {
                res[i] = right[rIndex++];
            }
        }

        return res;
    }
}
