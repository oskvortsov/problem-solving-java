package others;

// https://leetcode.com/problems/excel-sheet-column-number/description/

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int result = 0, size = columnTitle.length();

        for (int i = 0; i < size; i++) {
            int pow = size - i - 1;
            int val = (columnTitle.charAt(i) - 'A') + 1;

            result += (int) Math.pow(26, pow) * val;
        }

        return result;
    }
}
