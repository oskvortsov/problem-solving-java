package topic.array;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
public class RemoveDuplicatesFromSortedArrayTwo {
    public int removeDuplicates(int[] nums) {
        int trueIndex = 1, index = 1;
        int numberInRow = 1, prev = nums[0];

        while (index < nums.length) {
            if (prev == nums[index]) {
                numberInRow++;
            } else {
                numberInRow = 1;
                prev = nums[index];
            }
            index++;

            if (numberInRow < 3) trueIndex++;
            if (index < nums.length) nums[trueIndex] = nums[index];
        }

        return trueIndex;
    }
}
