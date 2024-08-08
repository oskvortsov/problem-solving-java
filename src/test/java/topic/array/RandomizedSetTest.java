package topic.array;

import org.junit.Test;
import others.RandomizedSet;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomizedSetTest {
    @Test
    public void case1() {
        RandomizedSet obj = new RandomizedSet();

        obj.insert(1);
        obj.insert(2);

        assertThat(obj.remove(1)).isTrue();
        assertThat(obj.getRandom()).isEqualTo(2);
    }

    @Test
    public void case2() {
        RandomizedSet obj = new RandomizedSet();

        obj.insert(0);
        obj.insert(1);
        obj.remove(0);
        obj.insert(2);

        assertThat(obj.remove(1)).isTrue();
        assertThat(obj.getRandom()).isEqualTo(2);
    }

    @Test
    public void case3() {
        RandomizedSet obj = new RandomizedSet();

        obj.remove(0);
        obj.remove(0);
        obj.insert(0);
        assertThat(obj.getRandom()).isEqualTo(0);
        assertThat(obj.remove(0)).isTrue();
        assertThat(obj.insert(0)).isTrue();
    }
}

