package topic.array;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MergeIntervalsTest {
    @Test()
    public void case1() {
        MergeIntervals obj = new MergeIntervals();
        var givenInterval = new int[][] {
                new int[] {1,4},
                new int[] {4,5},
        };
        var expectedInterval = new int[][] {
                new int[] {1,5},
        };

        assertThat(obj.merge(givenInterval)).isEqualTo(expectedInterval);
    }
}
