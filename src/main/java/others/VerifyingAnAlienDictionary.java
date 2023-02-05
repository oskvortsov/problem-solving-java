package others;

public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) orderMap[order.charAt(i) - 'a'] = i;

        for (int i = 0; i < words.length - 1; i++) {
            if (!isOrder(words[i], words[i + 1], orderMap)) {
                return false;
            }
        }

        return true;

    }

    private boolean isOrder(String a, String b, int[] mapOrder) {
        for (int i = 0; i < a.length(); i++) {
            if (b.length() == i) {
                return false;
            }

            int first = mapOrder[a.charAt(i) - 'a'];
            int second = mapOrder[b.charAt(i) - 'a'];

            if (first == second) continue;

            return first < second;
        }

        return true;
    }
}
