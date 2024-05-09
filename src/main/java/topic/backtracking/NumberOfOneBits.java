package topic.backtracking;

public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) if ((1 << i & n) != 0) ans++;
        return ans;
    }
}
