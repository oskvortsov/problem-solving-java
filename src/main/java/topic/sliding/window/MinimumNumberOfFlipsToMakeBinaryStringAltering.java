package topic.sliding.window;

// https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/description/

public class MinimumNumberOfFlipsToMakeBinaryStringAltering {
    public int minFlips1(String s) {
        int size = s.length(), oddDiffs = 0, evenDiffs = 0, answer = s.length();
        s = s + s;
        char[] oddSb = new char[s.length()], evenSb = new char[s.length()];


        for (int i = 0; i < s.length(); i++) {
            oddSb[i] = i % 2 == 1 ? '0' : '1';
            evenSb[i] = i % 2 == 0 ? '0' : '1';
        }

        int l = 0;
        while (l < s.length()) {
            oddDiffs += s.charAt(l) != oddSb[l] ? 1 : 0;
            evenDiffs += s.charAt(l) != evenSb[l] ? 1 : 0;

            int idx = l - size;
            if (idx >= 0) {
                oddDiffs -= s.charAt(idx) != oddSb[idx] ? 1 : 0;
                evenDiffs -= s.charAt(idx) != evenSb[idx] ? 1 : 0;

                answer = Math.min(answer, Math.min(oddDiffs, evenDiffs));
            }

            l++;
        }

        return answer;
    }

    public int minFlips(String s) {
        int size = s.length();
        int oddDiffs = 0, evenDiffs = 0, answer = s.length();
        s = s + s;

        for (int l = 0; l < s.length(); l++) {
            char cur = s.charAt(l);
            int idx = l - size;

            if (l % 2 == 1) {
                oddDiffs += cur == '0' ? 0 : 1;
                evenDiffs += cur == '1' ? 0 : 1;
            } else {
                oddDiffs += cur == '1' ? 0 : 1;
                evenDiffs += cur == '0' ? 0 : 1;
            }

            if (idx >= 0) {
                char first = s.charAt(idx);

                if (idx % 2 == 1) {
                    oddDiffs -= first == '0' ? 0 : 1;
                    evenDiffs -= first == '1' ? 0 : 1;
                } else {
                    oddDiffs -= first == '1' ? 0 : 1;
                    evenDiffs -= first == '0' ? 0 : 1;
                }
                answer = Math.min(answer, Math.min(evenDiffs, oddDiffs));
            }
        }

        return answer;
    }
}
