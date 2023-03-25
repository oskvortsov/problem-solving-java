package data.structure.union.find;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberOfOperationsToMakeNetworkConnectedTest {
    NumberOfOperationsToMakeNetworkConnected obj = new NumberOfOperationsToMakeNetworkConnected();

    @Test()
    public void case1() {
        assertThat(obj.makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}})).isEqualTo(1);
    }

    @Test()
    public void case2() {
        assertThat(obj.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}})).isEqualTo(2);
    }
}

