package topic.grady;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HandOfStraightsTest {
    @Test
    public void case1() {
        HandOfStraights obj = new HandOfStraights();
        assertThat(obj.isNStraightHand(new int[] { 1,2,3,6,2,3,4,7,8 }, 3)).isEqualTo(true);
    }

    @Test
    public void case2() {
        HandOfStraights obj = new HandOfStraights();
        assertThat(obj.isNStraightHand(new int[] {1,2,3,4,5 }, 3)).isEqualTo(false);
    }

    @Test
    public void case3() {
        HandOfStraights obj = new HandOfStraights();
        assertThat(obj.isNStraightHand(new int[] { 8, 10, 12 }, 3)).isEqualTo(false);
    }

    @Test
    public void case4() {
        HandOfStraights obj = new HandOfStraights();
        assertThat(obj.isNStraightHand(new int[] { 5,1,0,6,4,5,3,0,8,9 }, 2)).isEqualTo(false);
    }

    @Test
    public void case5() {
        HandOfStraights obj = new HandOfStraights();
        assertThat(obj.isNStraightHand(new int[] { 1,1,2,2,3,3 }, 2)).isEqualTo(false);
    }

    @Test
    public void case6() {
        HandOfStraights obj = new HandOfStraights();
        assertThat(obj.isNStraightHand(new int[] { 1,1,2,2,3,3 }, 3)).isEqualTo(true);
    }
}
