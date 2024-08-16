package data.structure.heap;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class KClosestPointsToOriginTest {
    @Test()
    public void case1() {
        KClosestPointsToOrigin obj = new KClosestPointsToOrigin();
        var givenCoords = new int[][] {new int[]{1, 3}, new int[] { -2, 2}};
        assertThat(obj.kClosest(givenCoords, 1)).isEqualTo(new int[][] { new int[] { -2, 2 } });
    }

    @Test()
    public void case2() {
        KClosestPointsToOrigin obj = new KClosestPointsToOrigin();
        var givenCoords = new int[][] {new int[]{3, 3}, new int[] { 5, -1}, new int[] { -2, 4 }};
        assertThat(obj.kClosest(givenCoords, 2)).isEqualTo(new int[][] { new int[]{3, 3}, new int[] { -2, 4 } });
    }
}
