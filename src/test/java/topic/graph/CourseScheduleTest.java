package topic.graph;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CourseScheduleTest {
    @Test()
    public void case1() {
        CourseSchedule obj = new CourseSchedule();

        assertThat(obj.canFinish(
                2,
                new int[][] { new int[]{1, 0}, new int[] { 0, 1}}
        )).isFalse();
    }

    @Test()
    public void case2() {
        CourseSchedule obj = new CourseSchedule();

        assertThat(obj.canFinish(
                2,
                new int[][] { new int[]{1, 0}}
        )).isTrue();
    }

    @Test()
    public void case3() {
        CourseSchedule obj = new CourseSchedule();

        assertThat(obj.canFinish(
                3,
                new int[][] {
                        new int[]{0, 1},
                        new int[]{0, 2},
                        new int[]{1, 2},
                }
        )).isTrue();
    }
}
