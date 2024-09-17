package data.structure.greedy;

import org.junit.Test;
import topic.greedy.ReducingDishes;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReducingDishesTest {
    ReducingDishes obj = new ReducingDishes();

    @Test()
    public void case1() {
        assertThat(obj.maxSatisfaction(new int[] { -1,-8,0,5,-9 })).isEqualTo(14);
    }

    @Test()
    public void case2() {
        assertThat(obj.maxSatisfaction(new int[] { 4,3,2 })).isEqualTo(20);
    }

    @Test()
    public void case3() {
        assertThat(obj.maxSatisfaction(new int[] { -1,-4,-5 })).isEqualTo(0);
    }

    @Test()
    public void case4() {
        assertThat(obj.maxSatisfaction(new int[] { -5,-7,8,-2,1,3,9,5,-10,4,-5,-2,-1,-6 })).isEqualTo(260);
    }
}

