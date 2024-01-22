package topic.binary.search;

import org.junit.Test;
import topic.binary.search.MinimumTimeToCompleteTrips;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MinimumTimeToCompleteTripsTest {
    MinimumTimeToCompleteTrips obj = new MinimumTimeToCompleteTrips();

    @Test()
    public void case1() {
        int[] time = new int[] { 5,10,10 };
        int totalTrips = 6;

        assertThat(obj.minimumTime(time, totalTrips)).isEqualTo(20);
    }

    @Test()
    public void case2() {
        int[] time = new int[] { 10000 };
        int totalTrips = 10000000;

        assertThat(obj.minimumTime(time, totalTrips)).isEqualTo(100000000000L);
    }
}

