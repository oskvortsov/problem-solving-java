package data.structure.heap;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TaskSchedulerTest {
    @Test()
    public void case1() {
        TaskScheduler obj = new TaskScheduler();
        assertThat(obj.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)).isEqualTo(8);
    }

    @Test()
    public void case2() {
        TaskScheduler obj = new TaskScheduler();
        assertThat(obj.leastInterval(new char[] { 'A','C','A','B','D','B' }, 1)).isEqualTo(6);
    }

    @Test()
    public void case3() {
        TaskScheduler obj = new TaskScheduler();
        assertThat(obj.leastInterval(new char[] { 'A','A','A', 'B','B','B' }, 3)).isEqualTo(10);
    }
}