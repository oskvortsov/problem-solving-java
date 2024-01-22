package topic.binary.search;

import org.junit.Test;
import topic.binary.search.FindMinimumInRotatedSortedArray;

import static org.assertj.core.api.Assertions.assertThat;

public class FindMinimumInRotatedSortedArrayTest {
    @Test
    public void case1() {
        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
        assertThat(obj.findMin(new int[] { 4,5,6,7,0,1,2 })).isEqualTo(0);
    }

    @Test
    public void case2() {
        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
        assertThat(obj.findMin(new int[] { 3,4,5,1,2 })).isEqualTo(1);
    }

    @Test
    public void case3() {
        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
        assertThat(obj.findMin(new int[] { 11,13,15,17 })).isEqualTo(11);
    }

    @Test
    public void case4() {
        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
        assertThat(obj.findMin(new int[] { 3,1,2 })).isEqualTo(1);
    }

    @Test
    public void case5() {
        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
        assertThat(obj.findMin(new int[] { 2, 1 })).isEqualTo(1);
    }

    @Test
    public void case6() {
        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
        assertThat(obj.findMin(new int[] { 2, 3, 1 })).isEqualTo(1);
    }

    @Test
    public void case7() {
        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
        assertThat(obj.findMin(new int[] { 5,1,2,3,4 })).isEqualTo(1);
    }
}
