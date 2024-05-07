package others;

// https://leetcode.com/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150
public class IntegerToRoman {
    private static class RoomNumber {
        int nominal;
        String symbol;

        RoomNumber(int n, String c) {
            nominal = n;
            symbol = c;
        }
    }


    RoomNumber[] dictionary = new RoomNumber[]{
            new RoomNumber(1000, "M"),
            new RoomNumber(900, "CM"),
            new RoomNumber(500, "D"),
            new RoomNumber(400, "CD"),

            new RoomNumber(100, "C"),
            new RoomNumber(90, "XC"),
            new RoomNumber(50, "L"),
            new RoomNumber(40, "XL"),

            new RoomNumber(10, "X"),
            new RoomNumber(9, "IX"),
            new RoomNumber(5, "V"),
            new RoomNumber(4, "IV"),

            new RoomNumber(1, "I"),
    };

    public String intToRoman1(int num) {
        StringBuilder sb = new StringBuilder();

        for (RoomNumber obj : dictionary) {
            if (num >= obj.nominal) {
                sb.append(obj.symbol.repeat(num / obj.nominal));
                num %= obj.nominal;
            }
        }

        return sb.toString();
    }


    private int[] nominals = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private String[] symbols = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nominals.length; i++) {
            if (num >= nominals[i]) {
                sb.append(symbols[i].repeat(num / nominals[i]));
                num %= nominals[i];
            }
        }

        return sb.toString();
    }
}
