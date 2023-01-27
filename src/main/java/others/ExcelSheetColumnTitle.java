package others;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();

        while (columnNumber > 26) {
            int nextCharInt = columnNumber % 26;
            res.append(getCharByNumber(nextCharInt));
            columnNumber = columnNumber / 26;
        }

        res.append(getCharByNumber(columnNumber));

        return res.reverse().toString();
    }

    private String getCharByNumber(int i) {
        return i > 0 & i < 27 ? String.valueOf((char) (i + 'A' - 1)) : null;
    }
}
