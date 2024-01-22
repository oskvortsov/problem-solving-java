package topic.binary.search;

import org.junit.Test;
import topic.binary.search.SingleElementInASortedArray;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingleElementInASortedArrayTest {
    @Test()
    public void case1() {
        SingleElementInASortedArray obj = new SingleElementInASortedArray();
        assertThat(obj.singleNonDuplicate(new int[] { 1,1,2,3,3,4,4,8,8 })).isEqualTo(2);
        assertThat(obj.singleNonDuplicate(new int[] { 3,3,7,7,10,11,11 })).isEqualTo(10);
    }
}

