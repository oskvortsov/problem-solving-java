package topic.binary.search;

// https://leetcode.com/problems/single-element-in-a-sorted-array/
public class SingleElementInASortedArray {
    // 3,3,7,7,10,11,11
    // 1,1,2,3,3,4,4,8,8
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int left = mid - 1 >= 0 ? nums[mid - 1] : -1;
            int right = mid + 1 < nums.length ? nums[mid + 1] : -1;

            if (nums[mid] != left && nums[mid] != right) {
                return nums[mid];
            }

            if (mid % 2 == 0 ? nums[mid] == left : nums[mid] == right) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return nums[r];
    }
}
