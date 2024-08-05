package others;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExcelSheetColumnNumberTest {
    @Test()
    public void case1() {
        ExcelSheetColumnNumber obj = new ExcelSheetColumnNumber();
        assertThat(obj.titleToNumber("A")).isEqualTo(1);
    }

    @Test()
    public void case2() {
        ExcelSheetColumnNumber obj = new ExcelSheetColumnNumber();
        assertThat(obj.titleToNumber("AB")).isEqualTo(28);
    }

    @Test()
    public void case3() {
        ExcelSheetColumnNumber obj = new ExcelSheetColumnNumber();
        assertThat(obj.titleToNumber("ZY")).isEqualTo(701);
    }
}
