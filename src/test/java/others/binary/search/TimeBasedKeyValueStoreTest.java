package others.binary.search;

import org.junit.Test;
import topic.binary.search.TimeBasedKeyValueStore;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeBasedKeyValueStoreTest {
    @Test
    public void case1() {
        TimeBasedKeyValueStore timeMap = new TimeBasedKeyValueStore();

        timeMap.set("foo", "bar", 1);
        assertThat(timeMap.get("foo", 1)).isEqualTo("bar");
        assertThat(timeMap.get("foo", 3)).isEqualTo("bar");;

        timeMap.set("foo", "bar2", 4);
        assertThat(timeMap.get("foo", 4)).isEqualTo("bar2");
        assertThat(timeMap.get("foo", 5)).isEqualTo("bar2");

    }
}
