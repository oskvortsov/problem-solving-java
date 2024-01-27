package topic.linked.list;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindTheDuplicateNumberTest {
    @Test
    public void case1() {
        FindTheDuplicateNumber obj = new FindTheDuplicateNumber();
        assertThat(obj.findDuplicate(new int[] { 1,3,4,2,2 })).isEqualTo(2);
    }

    @Test
    public void case2() {
        FindTheDuplicateNumber obj = new FindTheDuplicateNumber();
        assertThat(obj.findDuplicate(new int[] { 2,2,2,2,2 })).isEqualTo(2);
    }

    @Test
    public void case3() {
        FindTheDuplicateNumber obj = new FindTheDuplicateNumber();
        assertThat(obj.findDuplicate(new int[] { 3,1,3,4,2 })).isEqualTo(3);
    }

    @Test
    public void case4() {
        FindTheDuplicateNumber obj = new FindTheDuplicateNumber();
        assertThat(obj.findDuplicate(new int[] { 2,5,9,6,9,3,8,9,7,1 })).isEqualTo(9);
    }
}
