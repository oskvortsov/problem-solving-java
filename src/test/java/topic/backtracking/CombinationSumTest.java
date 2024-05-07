package topic.backtracking;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CombinationSumTest {
    @Test
    public void case1() {
        CombinationSum obj = new CombinationSum();
        assertThat(obj.combinationSum(new int[] { 2,3,6,7 }, 7)).isEqualTo(List.of(
                List.of(2,2,3), List.of(7)
        ));
    }

    @Test
    public void case2() {
        CombinationSum obj = new CombinationSum();
        assertThat(obj.combinationSum(new int[] { 2,3,5 }, 8)).isEqualTo(List.of(
                List.of(2,2,2,2), List.of(2,3,3), List.of(3,5)
        ));
    }

    @Test
    public void case3() {
        CombinationSum obj = new CombinationSum();
        assertThat(obj.combinationSum(new int[] { 3,5,8 }, 11)).isEqualTo(List.of(
                List.of(3, 3, 5), List.of(3, 8)
        ));
    }
}
