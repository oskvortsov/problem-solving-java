package topic.binary.search;

import org.junit.Test;
import topic.binary.search.MedianOfTwoSortedArrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MedianOfTwoSortedArraysTest {
    @Test
    public void case1() {
        MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
        assertThat(obj.findMedianSortedArrays(new int[] { 1, 2}, new int[] {3, 4})).isEqualTo(2.5);
    }
}
