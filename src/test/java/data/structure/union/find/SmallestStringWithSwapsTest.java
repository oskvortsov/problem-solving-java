package data.structure.union.find;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SmallestStringWithSwapsTest {
    SmallestStringWithSwaps obj = new SmallestStringWithSwaps();

    @Test()
    public void case1() {
        assertThat(obj.smallestStringWithSwaps(
                "dcab", List.of(List.of(0, 3), List.of(1, 2))
        )).isEqualTo("bacd");
    }

    @Test()
    public void case2() {
        assertThat(obj.smallestStringWithSwaps(
                "dcab", List.of(List.of(0, 3), List.of(1, 2), List.of(0, 2))
        )).isEqualTo("abcd");
    }
}

