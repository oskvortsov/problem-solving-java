package others;

import java.util.*;

// https://leetcode.com/problems/ipo/
public class IPO {
    class Project implements Comparable<Project> {
        int profit, capital;

        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        public int compareTo(Project project) {
            return capital - project.capital;
        }
    }

    public int findMaximizedCapital(int numOfFinishProject, int initialCapital, int[] profits, int[] capital) {
        Project[] projects = new Project[profits.length];
        for (int i = 0; i < projects.length; i++) {
            projects[i] = new Project(profits[i], capital[i]);
        }
        Arrays.sort(projects);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int point = 0;

        while (numOfFinishProject > 0) {
            while (point < projects.length && projects[point].capital <= initialCapital) {
                pq.add(projects[point++].profit);
            }

            if (pq.isEmpty()) break;

            initialCapital += pq.poll();
            numOfFinishProject--;
        }

        return initialCapital;
    }

    public int findMaximizedCapital2(int numOfFinishProject, int initialCapital, int[] profits, int[] capital) {
        PriorityQueue<Integer> pqProfit = new PriorityQueue<>((a, b) -> b - a);

        TreeMap<Integer, List<Integer>> orderCapital = new TreeMap<>();

        for (int i = 0; i < capital.length; i++) {
            if (!orderCapital.containsKey(capital[i])) {
                orderCapital.put(capital[i], new ArrayList<>());
            }

            orderCapital.get(capital[i]).add(profits[i]);
        }

        while (numOfFinishProject > 0) {
            while (!orderCapital.isEmpty() && orderCapital.firstKey() <= initialCapital) {
                pqProfit.addAll(orderCapital.pollFirstEntry().getValue());
            }

            if (!pqProfit.isEmpty()) {
                initialCapital += pqProfit.poll();
            }
            numOfFinishProject--;
        }

        return initialCapital;
    }

    public int findMaximizedCapital1(int numOfFinishProject, int initialCapital, int[] profits, int[] capital) {
        TreeMap<Integer, PriorityQueue<Integer>> capitalByProfit  = new TreeMap<>();

        for (int i = 0; i < capital.length; i++) {
            if (!capitalByProfit.containsKey(profits[i])) {
                capitalByProfit.put(profits[i], new PriorityQueue<>());
            }

            capitalByProfit.get(profits[i]).add(capital[i]);
        }

        while (numOfFinishProject > 0) {
            int maxProfit = 0;
            int curCapital = -1;

            for (int profit: capitalByProfit.keySet()) {
                int cap = capitalByProfit.get(profit).peek();

                if (cap <= initialCapital && profit > maxProfit) {
                    curCapital = cap;
                    maxProfit = profit;
                }
            }

            if (curCapital == -1) {
                break;
            }

            capitalByProfit.get(maxProfit).poll();

            if (capitalByProfit.get(maxProfit).isEmpty()) {
                capitalByProfit.remove(maxProfit);
            }

            initialCapital += maxProfit;

            numOfFinishProject--;
            curCapital = -1;
            maxProfit = 0;
        }

        return initialCapital;
    }
}
