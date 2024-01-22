package topic.binary.search;

import org.junit.Test;
import topic.binary.search.KokoEatingBananas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class KokoEatingBananasTest {
    @Test()
    public void case1() {
        KokoEatingBananas keb = new KokoEatingBananas();

        assertThat(keb.minEatingSpeed(new int[] { 3,6,7,11 }, 8)).isEqualTo(4);
        assertThat(keb.minEatingSpeed(new int[] { 30,11,23,4,20 }, 5)).isEqualTo(30);
        assertThat(keb.minEatingSpeed(new int[] { 30,11,23,4,20 }, 6)).isEqualTo(23);
    }
}
