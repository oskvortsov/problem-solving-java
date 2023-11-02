package topic.binary.search;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) return mid;

            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

    public int search1(int[] nums, int target) {
        int pivotIndex = findPivotIndex(nums);

        int l = 0, r = nums.length - 1;

        if (target > nums[r]) {
            r = pivotIndex - 1;
        } else {
            l = pivotIndex;
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    private int findPivotIndex(int[] nums) {
        int pivot = 0;
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            if (nums[l] < nums[r]) {
                pivot = nums[l] < nums[pivot] ? l : pivot;
                break;
            }

            int mid = l + (r - l) / 2;
            pivot = nums[mid] < nums[pivot] ? mid : pivot;

            if (nums[l] <= nums[mid]) {
                l =  mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return pivot;
    }
}
