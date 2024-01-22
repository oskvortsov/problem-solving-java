package topic.binary.search;

import org.junit.Test;
import topic.binary.search.SearchInRotatedSortedArray;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchInRotatedSortedArrayTest {
    @Test
    public void case1() {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        assertThat(obj.search(new int[] { 4,5,6,7,0,1,2 }, 0)).isEqualTo(4);
    }

    @Test
    public void case2() {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        assertThat(obj.search(new int[] { 4,5,6,7,0,1,2 }, 3)).isEqualTo(-1);
    }

    @Test
    public void case3() {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        assertThat(obj.search(new int[] { 1 }, 0)).isEqualTo(-1);
    }
}
