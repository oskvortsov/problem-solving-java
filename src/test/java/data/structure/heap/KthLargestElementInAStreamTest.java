package data.structure.heap;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class KthLargestElementInAStreamTest {
    KthLargestElementInAStream obj = new KthLargestElementInAStream();

    @Test()
    public void case1() {
        KthLargestElementInAStream.KthLargest kthLargest = obj.create(3, new int[]{4, 5, 8, 2});
        assertThat(kthLargest.add(3)).isEqualTo(4);
        assertThat(kthLargest.add(5)).isEqualTo(5);
        assertThat(kthLargest.add(10)).isEqualTo(5);
        assertThat(kthLargest.add(9)).isEqualTo(8);
        assertThat(kthLargest.add(4)).isEqualTo(8);
    }
}

