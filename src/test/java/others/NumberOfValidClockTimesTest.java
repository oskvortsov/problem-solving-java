package others;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberOfValidClockTimesTest {
    @Test()
    public void case1() {
        // given
        NumberOfValidClockTimes obj = new NumberOfValidClockTimes();

        // when
        assertThat(obj.countTime("0?:0?")).isEqualTo(100);
    }
}
