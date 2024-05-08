package topic.backtracking;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationsTest {
    @Test
    public void case1() {
        Permutations obj = new Permutations();
        assertThat(obj.permute(new int[]{1, 2, 3})).isEqualTo(
                List.of(
                        List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1)
                )
        );
    }
}
