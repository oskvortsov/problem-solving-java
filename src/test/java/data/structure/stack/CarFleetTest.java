package data.structure.stack;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFleetTest {
    @Test
    public void case1() {
        CarFleet obj = new CarFleet();
        assertThat(obj.carFleet(12, new int[] { 10,8,0,5,3 } , new int[] { 2,4,1,1,3 })).isEqualTo(3);
    }

    @Test
    public void case2() {
        CarFleet obj = new CarFleet();
        assertThat(obj.carFleet(100, new int[] { 0,2,4 } , new int[] { 4,2,1 })).isEqualTo(1);
    }
}
