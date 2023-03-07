package topic.dynamic.programming;

// https://leetcode.com/problems/jump-game-iv/

/*
Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

arr = [7,6,9,6,9,6,9,7] = 3
dp =  [0,1,2,3,4,5,6,7] = 3

 */

import java.util.*;

public class JumpGameIV {
    public int minJumps(int[] arr) {
        int finalPoint = arr.length - 1;
        HashMap<Integer, List<Integer>> positionByNum = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            positionByNum.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int j = queue.poll();

                if (j == finalPoint) {
                    return step;
                }

                List<Integer> list = positionByNum.get(arr[j]);
                list.add(j - 1);
                list.add(j + 1);

                for (int v: list) {
                    if (v >= 0 && v <= finalPoint && !visited.contains(v)) {
                        queue.add(v);
                        visited.add(v);
                    }
                }

                list.clear();
            }
            step++;
        }

        return -1;
    }


    // best solutions from leetcode
    public int minJumps1(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            List<Integer> list = map.get(arr[i]);
            if(list == null) map.put(arr[i], list = new ArrayList<>());
            list.add(i);
        }
        int[] visited = new int[n];
        Deque<Integer> forward = new LinkedList<>(), backward = new LinkedList<>();
        visited[0] = 1;
        forward.add(0);
        visited[n - 1] = 2;
        backward.add(n - 1);
        for(int res = 1, dir = 1; ; res++) {
            if(forward.size() > backward.size()) {
                Deque<Integer> temp = forward; forward = backward; backward = temp;
                dir = 3 - dir;
            }
            for(int size = forward.size(); size-- > 0; ) {
                int i = forward.poll();
                List<Integer> list = map.get(arr[i]);
                if(i - 1 >= 0) list.add(i - 1);
                if(i + 1 < n) list.add(i + 1);
                for(int j: list) {
                    if(visited[j] == 0) {
                        visited[j] = dir;
                        forward.add(j);
                    } else if(visited[j] != dir) return res;
                }
                list.clear();
            }
        }
    }
}
