package topic.binary.search;

// 0,1,2,3,4
// 1,2,3,4 k = 5
public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] - (mid + 1) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        int kPositive = arr[l] - l - 1;

        if (kPositive < k) {
            return arr[l] + (k - kPositive);
        }

        return arr[l] - (kPositive - k + 1);
    }

    public static void main(String[] args) {
        KthMissingPositiveNumber obj = new KthMissingPositiveNumber();
        obj.findKthPositive(new int[] { 2,3,4,7,11 }, 5);
        obj.findKthPositive(new int[] { 1,2,3,4 }, 2);
        obj.findKthPositive(new int[] { 1,10,21,22,25 }, 12);
    }
}
