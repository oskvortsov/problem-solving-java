package topic.sliding.window;

public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, index = 0;

        while (index < m + n) {
            if (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    merged[index++] = nums1[i++];
                } else {
                    merged[index++] = nums2[j++];
                }
                continue;
            }

            if (i < m) merged[index++] = nums1[i++];
            if (j < n) merged[index++] = nums2[j++];
        }
        int mid = merged.length / 2;

        if (merged.length % 2 == 0) {
            return (double) (merged[mid - 1] + merged[mid]) / 2;
        }

        return merged[mid];
    }
}
