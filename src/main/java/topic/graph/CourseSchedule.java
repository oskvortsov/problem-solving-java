package topic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        // fill the adj list
        for (int v = 0; v < numCourses; v++) adjList.put(v, new ArrayList<>());
        for (int[] pair: prerequisites) {
            int from = pair[0], to = pair[1];
            adjList.get(from).add(to);
        }

        HashSet<Integer> visited = new HashSet<>();

        for (int v = 0; v < numCourses; v++) {
            if (dfs(adjList, v, visited)) {
                return false;
            }
        }

        return true;
    }

    boolean dfs(HashMap<Integer, List<Integer>> adj, int cur, HashSet<Integer> visited) {
        if (visited.contains(cur)) {
            return true;
        }

        visited.add(cur);
        for (int i: adj.get(cur)) {
            if (dfs(adj, i, visited)) {
                return true;
            }
        }
        visited.remove(cur);
        adj.put(cur, List.of());

        return false;
    }

}
