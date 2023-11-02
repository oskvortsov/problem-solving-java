package topic.binary.search;


// 4,5,6,7,0,1,2
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int min = nums[0];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                min = Math.min(nums[l], min);
                break;
            }

            int mid = l + (r - l) / 2;
            min = Math.min(nums[mid], min);

            if (nums[l] <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return min;
    }
}
