package others.binary.search;

import org.junit.Test;
import topic.binary.search.MagneticForceBetweenTwoBalls;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MagneticForceBetweenTwoBallsTest {
    @Test()
    public void case1() {
        MagneticForceBetweenTwoBalls obj = new MagneticForceBetweenTwoBalls();

//        assertThat(obj.maxDistance(new int[] { 1,2,3,4,7 }, 3)).isEqualTo(3);
//        assertThat(obj.maxDistance(new int[] { 5,4,3,2,1,1000000000 }, 2)).isEqualTo(999999999);
        assertThat(obj.maxDistance(new int[] { 79,74,57,22 }, 4)).isEqualTo(5);

    }
}

