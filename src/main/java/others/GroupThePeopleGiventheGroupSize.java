package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
public class GroupThePeopleGiventheGroupSize {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> queue = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];


            if (queue.containsKey(groupSize)) {
                queue.get(groupSize).add(i);
            } else {
                queue.put(groupSize, new ArrayList<>());
                queue.get(groupSize).add(i);
            }

            List<Integer> group = queue.get(groupSize);

            if (group.size() == groupSize) {
                ans.add(group);
                queue.put(groupSize, new ArrayList<>());
            }
        }

        return ans;
    }
}
