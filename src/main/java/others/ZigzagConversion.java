package others;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int size = s.length();
        int step = 2 * numRows - 2;


        for (int i = 0; i < numRows; i++) {
            int index = i;
            int prev = 0;

            while (index < size) {
                sb.append(s.charAt(index));
                index += step;
                prev = index - i * 2;

                if (prev < size && i > 0 && i < numRows - 1) {
                    sb.append(s.charAt(prev));
                }
            }
        }

        return sb.toString();
    }
}
