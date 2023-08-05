package topic.prefix.sum;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RangeSumQuery2DImmutableTest {
    @Test()
    public void case1() {
        RangeSumQuery2DImmutable obj = new RangeSumQuery2DImmutable(new int[][]{
                {3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}
        });

        assertThat(obj.sumRegion(2, 1, 4, 3)).isEqualTo(8);
        assertThat(obj.sumRegion(1, 1, 2, 2)).isEqualTo(11);
        assertThat(obj.sumRegion(1, 2, 2, 4)).isEqualTo(12);
    }
}

