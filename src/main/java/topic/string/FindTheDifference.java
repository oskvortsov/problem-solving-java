package topic.string;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int sSum = 0;
        int tSum = t.codePointAt(t.length() - 1);

        for (int i = 0; i < s.length(); i++) {
            sSum += s.codePointAt(i);
            tSum += t.codePointAt(i);
        }

        return (char) (tSum - sSum);
    }
}
