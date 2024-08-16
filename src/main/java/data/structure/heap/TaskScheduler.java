package data.structure.heap;

// https://leetcode.com/problems/task-scheduler/description/

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TaskScheduler {
    private class Task {
        char label;
        int nextInterval;
        int count;

        Task(char label) {
            this.label = label;
            nextInterval = 0;
            count = 0;
        }
    }

    // Greedy
    public int leastInterval2(char[] tasks, int n) {
        // Counter array to store the frequency of each task
        int[] counter = new int[26];
        int maximum = 0;
        int maxCount = 0;

        // Traverse through tasks to calculate task frequencies
        for (char task : tasks) {
            counter[task - 'A']++;
            if (maximum == counter[task - 'A']) {
                maxCount++;
            }
            else if (maximum < counter[task - 'A']) {
                maximum = counter[task - 'A'];
                maxCount = 1;
            }
        }

        // Calculate idle slots, available tasks, and idles needed
        int partCount = maximum - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - maximum * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }

    // Filling slots
    public int leastInterval(char[] tasks, int n) {
        // Create a frequency array to keep track of the count of each task
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Sort the frequency array in non-decreasing order
        Arrays.sort(freq);
        // Calculate the maximum frequency of any task
        int maxFreq = freq[25] - 1;
        // Calculate the number of idle slots that will be required
        int idleSlots = maxFreq * n;

        // Iterate over the frequency array from the second highest frequency to the lowest frequency
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            // Subtract the minimum of the maximum frequency and the current frequency from the idle slots
            idleSlots -= Math.min(maxFreq, freq[i]);
        }

        // If there are any idle slots left, add them to the total number of tasks
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }

    // Heap Approach
    public int leastInterval1(char[] tasks, int n) {
        HashMap<Character, Task> taskMap = new HashMap<>();
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> a.nextInterval - b.nextInterval);
        int intervals = 0;

        for (char taskLabel : tasks) {
            if (!taskMap.containsKey(taskLabel)) {
                taskMap.put(taskLabel, new Task(taskLabel));
            }

            Task task = taskMap.get(taskLabel);
            task.count++;

            taskMap.put(taskLabel, task);
        }

        pq.addAll(taskMap.values());

        while (!pq.isEmpty()) {
            Task cur = pq.peek();

            if (cur.nextInterval <= intervals) {
                pq.poll();
                cur.count--;
                cur.nextInterval += n + 1;

                if (cur.count != 0) pq.add(cur);
            }

            intervals++;
        }


        return intervals;
    }
}
