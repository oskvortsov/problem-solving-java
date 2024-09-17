package data.structure.heap;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class KthLargestElementInAnArrayTest {
    @Test()
    public void case1() {
        KthLargestElementInAnArray obj = new KthLargestElementInAnArray();
        assertThat(obj.findKthLargest(new int[] { 3,2,1,5,6,4 }, 2)).isEqualTo(5);
    }
    
    @Test()
    public void case2() {
        KthLargestElementInAnArray obj = new KthLargestElementInAnArray();
        assertThat(obj.findKthLargest(new int[] { 3,2,3,1,2,4,5,5,6 }, 4)).isEqualTo(4);
    }

    @Test()
    public void case3() {
        KthLargestElementInAnArray obj = new KthLargestElementInAnArray();
        assertThat(obj.findKthLargest(new int[] { 3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6 }, 20)).isEqualTo(2);
    }
}