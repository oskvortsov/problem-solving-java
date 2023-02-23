package topic.array;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/sort-the-students-by-their-kth-score/
public class SortTheStudentsByTheirKthScore {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, Comparator.comparing(a -> a[k], (a, b) -> Integer.compare(b, a)));
        return score;
    }
}
