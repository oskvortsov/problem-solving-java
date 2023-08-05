package topic.array;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MinimizeMaximumOfArrayTest {
    MinimizeMaximumOfArray obj = new MinimizeMaximumOfArray();

    @Test()
    public void case1() {
        assertThat(obj.minimizeArrayValue(new int[] { 4,7,2,2,9,19,16,0,3,15 })).isEqualTo(9);
    }
}

