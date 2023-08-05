package others;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MaximumValueOfKCoinsFromPilesTest {
    @Test()
    public void case1() {
        MaximumValueOfKCoinsFromPiles obj = new MaximumValueOfKCoinsFromPiles();
        List<List<Integer>> piles = List.of(
                List.of(1, 1, 1000), // [1, 2, 1002]
                List.of(1, 1, 1000), // [1, 2, 1002]
                List.of(10, 100, 100), // [10, 110, 210]
                List.of(10, 100, 100), // [10, 110, 210]
                List.of(10, 100, 100) // [10, 110, 210]
        );
        /*
            n = 6

         */

        assertThat(obj.maxValueOfCoins(piles, 6)).isEqualTo(2004);
    }

    @Test()
    public void case2() {
        MaximumValueOfKCoinsFromPiles obj = new MaximumValueOfKCoinsFromPiles();
        List<List<Integer>> piles = List.of(
                List.of(1, 100, 3),
                List.of(7, 8, 9)
        );

        assertThat(obj.maxValueOfCoins(piles, 2)).isEqualTo(101);
    }

    @Test()
    public void case3() {
        MaximumValueOfKCoinsFromPiles obj = new MaximumValueOfKCoinsFromPiles();
        List<List<Integer>> piles = List.of(
                List.of(100),
                List.of(100),
                List.of(100),
                List.of(100),
                List.of(100),
                List.of(100),
                List.of(1,1,1,1,1,1,700)
        );

        assertThat(obj.maxValueOfCoins(piles, 7)).isEqualTo(706);
    }

    @Test()
    public void case4() {
        MaximumValueOfKCoinsFromPiles obj = new MaximumValueOfKCoinsFromPiles();
        List<List<Integer>> piles = List.of(
                List.of(1, 1, 1000), // [1, 2, 1002]
                List.of(512, 10, 1), // [512, 522, 523]
                List.of(512, 10, 1) // [512, 522, 523]
        );
        /*
            n = 3

         */

        assertThat(obj.maxValueOfCoins(piles, 3)).isEqualTo(1034);
    }
}

