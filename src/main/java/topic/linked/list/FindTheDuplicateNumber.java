package topic.linked.list;

// https://leetcode.com/problems/find-the-duplicate-number/

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
       int fast = 0, slow = 0;

       while (true) {
           fast = nums[nums[fast]];
           slow = nums[slow];

           if (slow == fast) break;
       }

       slow = 0;
       while (nums[slow] != nums[fast]) {
           fast = nums[fast];
           slow = nums[slow];
       }

        return nums[slow];
    }
}
