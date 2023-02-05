package topic.string;

// https://leetcode.com/problems/greatest-common-divisor-of-strings/
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        return str1.substring(0, nod(str1.length(), str2.length()));
    }

    // 45 % 25 = 20 || 25 % 20 = 5 || 20 % 5 = 0
    private int nod(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }

        return a + b;
    }
}
