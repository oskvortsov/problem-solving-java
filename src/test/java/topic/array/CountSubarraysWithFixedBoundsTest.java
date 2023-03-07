package topic.array;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CountSubarraysWithFixedBoundsTest {
    CountSubarraysWithFixedBounds obj = new CountSubarraysWithFixedBounds();

    @Test()
    public void case1() {
        assertThat(obj.countSubarrays(new int[] { 1,3,5,2,7,5 }, 1, 5)).isEqualTo(2);
    }

    @Test()
    public void case2() {
        assertThat(obj.countSubarrays(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 1, 1)).isEqualTo(45);
    }

    @Test()
    public void case4() {
        assertThat(obj.countSubarrays(new int[] { 1,2,1,2,5,2,5,2 }, 1, 5)).isEqualTo(12);
    }

    @Test()
    public void case3() {
        assertThat(obj.countSubarrays(
                new int[] { 35054,398719,945315,945315,820417,945315,35054,945315,171832,945315,35054,109750,790964,441974,552913 },
                35054, 945315
        )).isEqualTo(81);
    }
}