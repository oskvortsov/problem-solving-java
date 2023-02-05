package data.structure.trie;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapSumTest {
    @Test()
    public void case1() {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        assertThat(mapSum.sum("ap")).isEqualTo(3);           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        assertThat(mapSum.sum("ap")).isEqualTo(5);           // return 5 (apple + app = 3 + 2 = 5)
    }
}
