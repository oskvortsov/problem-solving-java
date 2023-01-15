package topic.array;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ThirdMaximumNumberSolutionTest {
    private ThirdMaximumNumberSolution solver = new ThirdMaximumNumberSolution();

    @Test
    public void case1() {
        int[] input = new int[] {3, 2, 1};
        int output = 1;

        assertThat(solver.thirdMaxMinHeap(input)).isEqualTo(output);
        assertThat(solver.thirdMaxSortSet(input)).isEqualTo(output);
    }

    @Test
    public void case2() {
        int[] input = new int[] {2, 1};
        int output = 2;

        assertThat(solver.thirdMaxMinHeap(input)).isEqualTo(output);
        assertThat(solver.thirdMaxSortSet(input)).isEqualTo(output);
    }

    @Test
    public void case3() {
        int[] input = new int[] {2, 2, 3, 1};
        int output = 1;

        assertThat(solver.thirdMaxMinHeap(input)).isEqualTo(output);
        assertThat(solver.thirdMaxSortSet(input)).isEqualTo(output);
    }

    @Test
    public void case4() {
        int[] input = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int output = 7;

        assertThat(solver.thirdMaxMinHeap(input)).isEqualTo(output);
        assertThat(solver.thirdMaxSortSet(input)).isEqualTo(output);
    }

}
