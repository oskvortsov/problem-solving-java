package data.structure.stack;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DailyTemperaturesTest {
    @Test()
    public void case1() {
        DailyTemperatures dt = new DailyTemperatures();
        int[] forecast = new int[] { 73,74,75,71,69,72,76,73 };
        int[] output = new int[] { 1,1,4,2,1,1,0,0 };

        assertThat(dt.dailyTemperatures(forecast)).isEqualTo(output);
    }
}
