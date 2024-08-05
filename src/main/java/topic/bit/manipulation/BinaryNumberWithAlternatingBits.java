package topic.bit.manipulation;

public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
       boolean prevValue = (n & 1) != 0;

       for (int i = 1; i < 32; i++) {
           if (1 << i > n) break;
           boolean curValue = (n & (1 << i)) != 0;
           if (curValue == prevValue) return false;
           prevValue = curValue;
       }

        return true;
    }
}
