package topic.graph;

import java.util.*;

// https://leetcode.com/problems/course-schedule-ii/description/
public class CourseScheduleTwo {
    // Implementation by mark as color
    private final byte WHITE = 0;
    private final byte GRAY = 1;
    private final byte BLACK = 2;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        byte[] color = new byte[numCourses];
        List<Integer> result = new ArrayList<>();


        for (int i = 0; i < numCourses; i++) adj.put(i, new ArrayList<>());
        for (int[] pair : prerequisites) adj.get(pair[0]).add(pair[1]);

        for (int i = 0; i < numCourses; i++) {
            if (color[i] == WHITE && dfs(adj, i, color, result)) {
                return new int[] {};
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean dfs(HashMap<Integer, List<Integer>> adj, int v, byte[] colors, List<Integer> order) {
        colors[v] = GRAY;

        for (int u : adj.get(v)) {
            if (colors[u] == GRAY) {
                return true;
            } else if (colors[u] == WHITE && dfs(adj, u, colors, order)) {
                return true;
            }
        }

        if (colors[v] == GRAY) {
            order.add(v);
        }
        colors[v] = BLACK;

        return false;
    }



    // Implementation with Sets
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < numCourses; i++) adj.put(i, new ArrayList<>());
        for (int[] pair : prerequisites) adj.get(pair[0]).add(pair[1]);

        Stack<Integer> order = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> added = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i) && dfs1(adj, i, visited, added, order)) {
                return new int[] {};
            }
        }

        int[] result = new int[order.size()];

        while (!order.isEmpty()) result[order.size() - 1] = order.pop();

        return result;
    }

    boolean dfs1(HashMap<Integer, List<Integer>> adj, int v, HashSet<Integer> visited, HashSet<Integer> added, Stack<Integer> order) {
        if (visited.contains(v)) {
            return true;
        }

        visited.add(v);
        for (int u : adj.get(v)) {
            if (dfs1(adj, u, visited, added, order)) {
                return true;
            }
        }
        visited.remove(v);

        adj.put(v, List.of());
        if (!added.contains(v)) {
            order.add(v);
            added.add(v);
        }

        return false;
    }
}
