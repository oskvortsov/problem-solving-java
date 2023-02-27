package topic.string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EditDistanceTest {
    @Test()
    public void case1() {
        EditDistance obj = new EditDistance();

//        assertThat(obj.minDistance("horse", "ros")).isEqualTo(3);
        assertThat(obj.minDistance("intention", "execution")).isEqualTo(5);
//        assertThat(obj.minDistance("zdbaz", "aabbdd")).isEqualTo(6); // 2 deletion, 1 replace, 3 insert
    }
}

