package topic.sliding.window;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SlidingWindowMaximumTest {
    @Test
    public void case1() {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        assertThat(obj.maxSlidingWindow(new int[] { 1,3,-1,-3,5,3,6,7 }, 3)).isEqualTo(new int[] { 3,3,5,5,6,7});
    }

    @Test
    public void case2() {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        assertThat(obj.maxSlidingWindow(new int[] { 7,2,4 }, 2)).isEqualTo(new int[] { 7, 4 });
    }

    @Test
    public void case3() {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        assertThat(obj.maxSlidingWindow(new int[] { 1,3,1,2,0,5 }, 3)).isEqualTo(new int[] { 3,3,2,5 });
    }

    @Test
    public void case4() {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        int[] bigInput = IntStream.generate(() -> new Random().nextInt(1000000)).limit(1000000).toArray();

        long startTime = System.currentTimeMillis();
        obj.maxSlidingWindow(bigInput, 50000);
        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;
        System.out.println("SlidingWindowMaximum: Execution time of maxSlidingWindow in case4: " + executionTime + "ms");
//        assertThat(executionTime).isLessThan(10L);
    }
}
