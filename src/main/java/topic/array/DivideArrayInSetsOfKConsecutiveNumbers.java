package topic.array;

import java.util.*;

// [1,2,3,3,4,4,5,6], k = 4
// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
public class DivideArrayInSetsOfKConsecutiveNumbers {
    class SubArr {
        public int size;
        private int last;
        private final int isFullSize;

        SubArr(int k) {
            last = -1;
            isFullSize = k;
            size = 0;
        }

        boolean isFull() {
            return size == isFullSize;
        }

        boolean add(int num) {
            if(isFull()) {
                return false;
            }

            if (last == -1 || last + 1 == num) {
                last = num;
                size++;
                return true;
            }

            return false;
        }
    }

    public boolean isPossibleDivide2(int[] nums, int k) {
        if (nums.length == k || nums.length % k != 0) {
            return false;
        }

        Arrays.sort(nums);
        List<Integer> orderKey = new ArrayList<>();
        HashMap<Integer, Integer> countNum = new HashMap<>();
        for (int num: nums) {
            int count = countNum.getOrDefault(num, 0) + 1;

            if (count == 1) {
                orderKey.add(num);
            }

            countNum.put(num, count);
        }

        for (int cur: orderKey) {
            int count = countNum.get(cur);

            if (count < 1) continue;

            for (int i = 1; i < k; ++i) {
                int next = cur + i;

                if (!countNum.containsKey(next)) {
                    return false;
                }

                countNum.put(next, countNum.get(next) - count);

                if (countNum.get(next) < 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        int[] arr = new int[k];//count mod k
        int previous = nums[0];
        Arrays.sort(nums);
        for(int x : nums){
            //if countinue previous mod can't bigger than current mod
            if(x == previous + 1 && arr[(previous - 1) % k] > arr[previous % k]) return false;
            //if not countinue previous mod can't not equal current mod
            if(x > previous + 1 && arr[(previous - 1) % k] != arr[previous % k]) return false;
            arr[x % k]++;//current mod++
            previous = x;//previous = current
        }
        return arr[(previous - 1) % k] == arr[previous % k];//previous mod must equal current mod
    }

    public boolean isPossibleDivide1(int[] nums, int k) {
        if (nums.length % k != 0 || nums.length == k) {
            return false;
        }

        Arrays.sort(nums);
        HashMap<Integer, Integer> countNumbers = new HashMap<>();
        List<Integer> orderKey = new ArrayList<>();
        int numOfSubArr = nums.length / k;

        for (int num: nums) {
            int count = countNumbers.getOrDefault(num, 0) + 1;

            if (count == 1) orderKey.add(num);

            if (count > numOfSubArr) {
                return false;
            }

            countNumbers.put(num, count);
        }


        SubArr[] subArrs = new SubArr[numOfSubArr];

        for (int i = 0; i < numOfSubArr; i++) {
            subArrs[i] = new SubArr(k);
        }

        for (int num: orderKey) {
            int avaliableNums = countNumbers.get(num);

            for (SubArr cur : subArrs) {
                if (avaliableNums == 0) break;
                if (cur.add(num)) avaliableNums--;
            }

            if (avaliableNums != 0) return false;
        }

        return true;
    }
}
