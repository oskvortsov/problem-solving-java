package topic.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductOfArrayExceptSelfTest {
    @Test
    public void case1() {
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        assertThat(obj.productExceptSelf(new int[] { 1, 2, 3, 4 })).isEqualTo(new int [] { 24, 12, 8, 6});
    }

    @Test
    public void case2() {
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        assertThat(obj.productExceptSelf(new int[] { -1, 1, 0, -3, 3 })).isEqualTo(new int [] { 0,0,9,0,0 });
    }

    @Test
    public void case3() {
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        assertThat(obj.productExceptSelf(new int[] { 0, 0 })).isEqualTo(new int [] { 0, 0 });
    }
}
