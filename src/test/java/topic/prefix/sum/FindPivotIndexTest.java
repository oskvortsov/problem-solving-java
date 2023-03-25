package topic.prefix.sum;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FindPivotIndexTest {
    FindPivotIndex obj = new FindPivotIndex();

    @Test()
    public void case1() {
        assertThat(obj.pivotIndex(new int[] { 1,7,3,6,5,6 })).isEqualTo(3);
    }

    @Test()
    public void case2() {
        assertThat(obj.pivotIndex(new int[] { 1,2,3 })).isEqualTo(-1);
    }

    @Test()
    public void case3() {
        assertThat(obj.pivotIndex(new int[] { 2,1,-1 })).isEqualTo(0);
    }

    @Test()
    public void case4() {
        assertThat(obj.pivotIndex(new int[] { -1,-1,0,1,1,0 })).isEqualTo(5);
    }
}

