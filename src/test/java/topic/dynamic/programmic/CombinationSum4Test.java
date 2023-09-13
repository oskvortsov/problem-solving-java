package topic.dynamic.programmic;

import org.junit.Test;
import topic.dynamic.programming.CombinationSum4;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CombinationSum4Test {
    @Test()
    public void case1() {
        CombinationSum4 obj = new CombinationSum4();

        assertThat(obj.combinationSum4(new int[] { 3, 1, 2, 4 }, 4)).isEqualTo(8);
        assertThat(obj.combinationSum4(new int[] { 1, 2, 3 }, 4)).isEqualTo(7);
        assertThat(obj.combinationSum4(new int[] { 9 }, 3)).isEqualTo(0);
    }
}
