package data.structure.stack;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LargestRectangleInHistogramTest {
    @Test
    public void case1() {
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        assertThat(obj.largestRectangleArea(new int[] { 2,1,5,6,2,3 })).isEqualTo(10);
    }

    @Test
    public void case2() {
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        assertThat(obj.largestRectangleArea(new int[] { 2, 4 })).isEqualTo(4);
    }

    @Test
    public void case3() {
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        assertThat(obj.largestRectangleArea(new int[] { 6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3 })).isEqualTo(14);
    }

    @Test
    public void case4() {
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        assertThat(obj.largestRectangleArea(new int[] { 3,1,4,5,3,2,7,5,3 })).isEqualTo(14);
    }

    @Test
    public void case5() {
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        assertThat(obj.largestRectangleArea(new int[] { 1,2,4,5,6,2 })).isEqualTo(12);
    }

    @Test
    public void case6() {
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        assertThat(obj.largestRectangleArea(new int[] { 1,2,3,4,5,2,1,1,1,1,1,1,1 })).isEqualTo(13);
    }

    @Test
    public void case7() {
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        assertThat(obj.largestRectangleArea(new int[] { 2,3,4,4,2,1,1,1,1,1,1,1 })).isEqualTo(12);
    }
}
