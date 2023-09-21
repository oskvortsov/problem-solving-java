package topic.dynamic.programmic;

import org.junit.Test;
import topic.dynamic.programming.OnesAndZeroes;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OnesAndZeroesTest {
    @Test
    public void case1() {
        OnesAndZeroes obj = new OnesAndZeroes();
        assertThat(obj.findMaxForm(new String[] { "10","0001","111001","1","0" }, 5, 3)).isEqualTo(4);
    }

    @Test
    public void case2() {
        OnesAndZeroes obj = new OnesAndZeroes();
        assertThat(obj.findMaxForm(new String[] { "10","0","1" }, 1, 1)).isEqualTo(2);
    }

    @Test
    public void case3TLE() {
        OnesAndZeroes obj = new OnesAndZeroes();
        assertThat(obj.findMaxForm(new String[] {
                "11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"
        }, 90, 66)).isEqualTo(29);
    }
}
