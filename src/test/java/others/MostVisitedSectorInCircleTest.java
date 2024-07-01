package others;

import org.junit.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MostVisitedSectorInCircleTest {
    @Test()
    public void case1() {
        // given
        MostVisitedSectorInCircle mostVisitedSectorInCircle = new MostVisitedSectorInCircle();
        int n = 4;
        int[] rounds = new int[] { 1,3,1,2 };

        // when
        List<Integer> expected = List.of(1, 2);
        assertThat(mostVisitedSectorInCircle.mostVisited(n, rounds)).isEqualTo(expected);
    }
}
