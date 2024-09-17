package topic.array;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InsertIntervalTest {
    @Test()
    public void case1() {
        InsertInterval obj = new InsertInterval();
        var givenInterval = new int[][] {
                new int[] {1,2},
                new int[] {3,5},
                new int[] {6,7},
                new int[] {8,10},
                new int[] {12,16},
        };
        var givenNewInterval = new int[] {
                4, 8
        };

        var expectedInterval = new int[][] {
                new int[] {1,2},
                new int[] {3,10},
                new int[] {12,16},
        };

        assertThat(obj.insert(givenInterval, givenNewInterval)).isEqualTo(expectedInterval);
    }

    @Test()
    public void case2() {
        InsertInterval obj = new InsertInterval();
        var givenInterval = new int[][] {
                new int[] {1,3},
                new int[] {6,9},
        };
        var givenNewInterval = new int[] {
                2, 5
        };

        var expectedInterval = new int[][] {
                new int[] {1,5},
                new int[] {6,9},
        };

        assertThat(obj.insert(givenInterval, givenNewInterval)).isEqualTo(expectedInterval);
    }

    @Test()
    public void case3() {
        InsertInterval obj = new InsertInterval();
        var givenInterval = new int[][] {};
        var givenNewInterval = new int[] {
                2, 5
        };

        var expectedInterval = new int[][] {
                new int[] {2,5},
        };

        assertThat(obj.insert(givenInterval, givenNewInterval)).isEqualTo(expectedInterval);
    }

    @Test()
    public void case4() {
        InsertInterval obj = new InsertInterval();
        var givenInterval = new int[][] {
                new int[] { 1, 5}
        };
        var givenNewInterval = new int[] {
                2, 3
        };

        var expectedInterval = new int[][] {
                new int[] {1,5},
        };

        assertThat(obj.insert(givenInterval, givenNewInterval)).isEqualTo(expectedInterval);
    }

    @Test()
    public void case5() {
        InsertInterval obj = new InsertInterval();
        var givenInterval = new int[][] {
                new int[] { 1, 5}
        };
        var givenNewInterval = new int[] {
                6, 8
        };

        var expectedInterval = new int[][] {
                new int[] {1,5},
                new int[] {6,8},
        };

        assertThat(obj.insert(givenInterval, givenNewInterval)).isEqualTo(expectedInterval);
    }

    @Test()
    public void case6() {
        InsertInterval obj = new InsertInterval();
        var givenInterval = new int[][] {
                new int[] { 0, 0}
        };
        var givenNewInterval = new int[] {
                1, 5
        };

        var expectedInterval = new int[][] {
                new int[] {0,0},
                new int[] {1,5},
        };

        assertThat(obj.insert(givenInterval, givenNewInterval)).isEqualTo(expectedInterval);
    }
}
