package topic.two.points;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoatsToSavePeopleTest {
    BoatsToSavePeople obj = new BoatsToSavePeople();

    @Test()
    public void case1() {
        assertThat(obj.numRescueBoats(new int[] { 1,2 }, 3)).isEqualTo(1);
    }

    @Test()
    public void case2() {
        assertThat(obj.numRescueBoats(new int[] { 3,2,2,1 }, 3)).isEqualTo(3);
    }

    @Test()
    public void case3() {
        assertThat(obj.numRescueBoats(new int[] { 3,5,3,4 }, 5)).isEqualTo(4);
    }

    @Test()
    public void case4() {
        assertThat(obj.numRescueBoats(new int[] { 5,1,4,2 }, 6)).isEqualTo(2);
    }

    @Test()
    public void case5() {
        assertThat(obj.numRescueBoats(new int[] { 3,2,3,2,2 }, 6)).isEqualTo(3);
    }
}

