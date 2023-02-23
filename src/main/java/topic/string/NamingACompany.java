package topic.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/naming-a-company/
public class NamingACompany {
    public long distinctNames(String[] ideas) {
        HashSet<String> idesSet = new HashSet<>(List.of(ideas));
        HashSet<String> uniqWord = new HashSet<>();

        for (int i = 0; i < ideas.length; i++) {
            for (int j = i + 1; j < ideas.length; j++) {
                String ideaA = ideas[j].charAt(0) + ideas[i].substring(1);
                String ideaB = ideas[i].charAt(0) + ideas[j].substring(1);

                if (!idesSet.contains(ideaA) && !idesSet.contains(ideaB)) {
                    uniqWord.add(ideaA);
                    uniqWord.add(ideaB);
                }
            }
        }

        if (uniqWord.size() == 0) {
            return 0;
        }

        return factorial(uniqWord.size()) / (2 * factorial(uniqWord.size() - 2));
    }

    public long factorial(long count) {
        int ans = 1;
        while (count != 0) ans *= count--;
        return ans;
    }
}
