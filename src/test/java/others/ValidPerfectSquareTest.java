package others;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidPerfectSquareTest {
    @Test()
    public void case1() {
        ValidPerfectSquare vps = new ValidPerfectSquare();
        assertThat(vps.isPerfectSquare(4)).isTrue();
        assertThat(vps.isPerfectSquare(2147395600)).isTrue();
        assertThat(vps.isPerfectSquare(808201)).isTrue();
        assertThat(vps.isPerfectSquare(9)).isTrue();
        assertThat(vps.isPerfectSquare(16)).isTrue();
        assertThat(vps.isPerfectSquare(1)).isTrue();

        assertThat(vps.isPerfectSquare(3)).isFalse();
    }
}
