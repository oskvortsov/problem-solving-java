package topic.two.points;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int l = 0, r = people.length - 1;

        while (l <= r) {
            int cur = limit;
            cur -= people[r--];
            answer++;

            if (cur >= people[l]) {
                l++;
            }
        }

        return answer;
    }
}
