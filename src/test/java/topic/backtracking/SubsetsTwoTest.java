package topic.backtracking;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SubsetsTwoTest {
    @Test
    public void case1() {
        SubsetsTwo obj = new SubsetsTwo();
        assertThat(obj.subsetsWithDup(new int[] { 1, 2, 2 })).isEqualTo(
                List.of(
                        List.of(), List.of(1), List.of(1,2), List.of(1,2,2), List.of(2), List.of(2,2)
                )
        );
    }
}
