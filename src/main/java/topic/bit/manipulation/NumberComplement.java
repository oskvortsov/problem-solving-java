package topic.bit.manipulation;

// https://leetcode.com/problems/number-complement/description/
class NumberComplement {
    public int findComplement(int num) {
        char[] binary = Integer.toBinaryString(num).toCharArray();
        int ans = 0;

        for (char bit: binary) {
            if (bit == '0') {
                ans |= 1;
            }

            ans <<= 1;
        }

        return ans >> 1;
    }

    public int findComplement2(int num) {
        int mask = num;

        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;

        return num ^ mask;
    }
}