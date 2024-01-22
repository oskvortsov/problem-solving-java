package topic.binary.search;

import org.junit.Test;
import topic.binary.search.CapacityToShipPackagesWithinDDays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CapacityToShipPackagesWithinDDaysTest {
    @Test()
    public void case1() {
        CapacityToShipPackagesWithinDDays obj  = new CapacityToShipPackagesWithinDDays();

        assertThat(obj.shipWithinDays(new int[] { 1,2,3,4,5,6,7,8,9,10 }, 5)).isEqualTo(15);
        assertThat(obj.shipWithinDays(new int[] { 3,2,2,4,1,4 }, 3)).isEqualTo(6);
        assertThat(obj.shipWithinDays(new int[] { 1,2,3,1,1 }, 4)).isEqualTo(3);
    }
}

