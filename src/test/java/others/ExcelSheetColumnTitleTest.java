package others;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ExcelSheetColumnTitleTest {
    @Test()
    public void cases() {
        ExcelSheetColumnTitle solver = new ExcelSheetColumnTitle();

        assertThat(solver.convertToTitle(701)).isEqualTo("ZY");
        assertThat(solver.convertToTitle(25)).isEqualTo("Y");
        assertThat(solver.convertToTitle(1)).isEqualTo("A");
        assertThat(solver.convertToTitle(52)).isEqualTo("AZ");
    }
}
