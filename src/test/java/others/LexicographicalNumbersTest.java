package others;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LexicographicalNumbersTest {
    @Test()
    public void case1() {
        // given
        LexicographicalNumbers lexicographicalNumbers = new LexicographicalNumbers();

        // when
        List<Integer> expected = List.of(1,10,11,12,13,2,3,4,5,6,7,8,9);

        // then
        assertThat(lexicographicalNumbers.lexicalOrder(13)).isEqualTo(expected);
    }

    @Test()
    public void case2() {
        // given
        LexicographicalNumbers lexicographicalNumbers = new LexicographicalNumbers();

        // when
        List<Integer> expected = lexicographicalNumbers.lexicalOrder(1000);

        // then
        assertThat(expected.size()).isEqualTo(1000);
    }
}
