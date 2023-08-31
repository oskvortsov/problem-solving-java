package topic.dynamic.programmic;

import org.junit.Test;
import topic.dynamic.programming.Triangle;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TriangleTest {
    @Test
    public void case1() {
        Triangle t = new Triangle();
        // [[2],[3,4],[6,5,7],[4,1,8,3]]
        assertThat(t.minimumTotal(List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6,5,4),
                List.of(4,1,8,3)
        ))).isEqualTo(11);
    }

    @Test
    public void case2() {
        Triangle t = new Triangle();
        // [[-10]]
        assertThat(t.minimumTotal(List.of(List.of(-10)))).isEqualTo(-10);
    }
}
