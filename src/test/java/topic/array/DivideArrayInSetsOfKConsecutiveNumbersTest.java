package topic.array;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DivideArrayInSetsOfKConsecutiveNumbersTest {
    DivideArrayInSetsOfKConsecutiveNumbers obj = new DivideArrayInSetsOfKConsecutiveNumbers();

    @Test()
    public void case1() {
        int[] input = new int[] { 1,2,3,3,4,4,5,6 };
        int k = 4;
        assertThat(obj.isPossibleDivide(input, k)).isTrue();
    }

    @Test()
    public void case2() {
        int[] input = new int[] { 3,2,1,2,3,4,3,4,5,9,10,11 };
        int k = 3;
        assertThat(obj.isPossibleDivide(input, k)).isTrue();
    }

    @Test()
    public void case3() {
        int[] input = new int[] { 1,2,3,4 };
        int k = 3;
        assertThat(obj.isPossibleDivide(input, k)).isFalse();
    }

    @Test()
    public void case4() {
        int[] input = new int[] { 1,2,2,2,3,4 };
        int k = 3;
        assertThat(obj.isPossibleDivide(input, k)).isFalse();
    }
}

