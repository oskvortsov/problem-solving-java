package others;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FruitIntoBasketsTest {
    @Test()
    public void case1() {
        FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
        assertThat(fruitIntoBaskets.totalFruit(new int[] { 1,2,1 })).isEqualTo(3);
        assertThat(fruitIntoBaskets.totalFruit(new int[] { 0,1,2,2 })).isEqualTo(3);
        assertThat(fruitIntoBaskets.totalFruit(new int[] { 1,2,3,2,2 })).isEqualTo(4);
    }
}
