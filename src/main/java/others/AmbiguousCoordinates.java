package others;

// https://leetcode.com/problems/ambiguous-coordinates/description/

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        s = s.substring(1, s.length() - 1);

        for (int x = 1; x < s.length(); x++) {
            List<String> numbersX = generateNumbers(s.substring(0, x));
            List<String> numbersY = generateNumbers(s.substring(x));

            if (!numbersX.isEmpty() && !numbersY.isEmpty()) {
                for (var dx: numbersX) {
                    for (var dy: numbersY) {
                        result.add("(" + dx + ", " + dy + ")");
                    }
                }
            }
        }


        return result;
    }

    public boolean isValid(String s) {
        if (s.contains(".")) {
            String[] parts = s.split("\\.");

            if (!parts[0].equals("0") && parts[0].startsWith("0")) return false;

            return !parts[1].endsWith("0");
        }

        return s.equals("0") || !s.startsWith("0");
    }

    public List<String> generateNumbers(String s) {
        List<String> pairs = new ArrayList<>();

        if (isValid(s)) pairs.add(s);

        for (int i = 1; i < s.length(); i++) {
            String num = s.substring(0, i) + "." + s.substring(i);
            if (isValid(num)) pairs.add(num);
        }

        return pairs;
    }
}
