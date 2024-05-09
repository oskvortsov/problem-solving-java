package topic.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveDuplicatesFromSortedArrayTwoTest {
    @Test
    public void case1() {
        RemoveDuplicatesFromSortedArrayTwo obj = new RemoveDuplicatesFromSortedArrayTwo();
        assertThat(obj.removeDuplicates(new int[] { 1,1,1,2,2,3 })).isEqualTo(5);
    }

    @Test
    public void case2() {
        RemoveDuplicatesFromSortedArrayTwo obj = new RemoveDuplicatesFromSortedArrayTwo();
        assertThat(obj.removeDuplicates(new int[] { 0,0,1,1,1,1,2,3,3 })).isEqualTo(7);
    }
}
