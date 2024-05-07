package topic.sliding.window;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MedianOfTwoSortedArrayTest {
    @Test
    public void case1() {
        MedianOfTwoSortedArray obj = new MedianOfTwoSortedArray();
        assertThat(obj.findMedianSortedArrays(new int[] { 1,2 }, new int[] {  3,4})).isEqualTo(2.5);
    }

    @Test
    public void case2() {
        MedianOfTwoSortedArray obj = new MedianOfTwoSortedArray();
        assertThat(obj.findMedianSortedArrays(new int[] { 1,3 }, new int[] {  2 })).isEqualTo(2);
    }
}
