package others;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AmbiguousCoordinatesTest {
    @Test()
    public void case1() {
        AmbiguousCoordinates obj = new AmbiguousCoordinates();
        assertThat(obj.isValid("00")).isEqualTo(false);
        assertThat(obj.isValid("0.0")).isEqualTo(false);
        assertThat(obj.isValid("0.00")).isEqualTo(false);
        assertThat(obj.isValid("1.0")).isEqualTo(false);
        assertThat(obj.isValid("001")).isEqualTo(false);
        assertThat(obj.isValid("00.01")).isEqualTo(false);

        assertThat(obj.isValid("0.1")).isEqualTo(true);
        assertThat(obj.isValid("0.0001")).isEqualTo(true);
    }

    @Test()
    public void case2() {
        AmbiguousCoordinates obj = new AmbiguousCoordinates();
        assertThat(obj.generateNumbers("123")).isEqualTo(List.of("123", "1.23", "12.3"));
    }

    @Test()
    public void case4() {
        AmbiguousCoordinates obj = new AmbiguousCoordinates();
        assertThat(obj.ambiguousCoordinates("(00011)")).isNotEmpty();
    }

    @Test()
    public void case3() {
        AmbiguousCoordinates obj = new AmbiguousCoordinates();
        assertThat(obj.ambiguousCoordinates("(123)")).isEqualTo(List.of("(1, 23)", "(1, 2.3)", "(12, 3)", "(1.2, 3)"));
    }
}
