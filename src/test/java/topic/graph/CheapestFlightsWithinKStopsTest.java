package topic.graph;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheapestFlightsWithinKStopsTest {
    @Test()
    public void case1() {
        CheapestFlightsWithinKStops obj = new CheapestFlightsWithinKStops();
        int[][] flights = new int[][]{
                {0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}
        };
        int kStops = 1;
        int numOfCities = 4;
        int form = 0, to = 3;

        assertThat(obj.findCheapestPrice(numOfCities, flights, form, to, kStops)).isEqualTo(700);
    }

    @Test()
    public void case2() {
        CheapestFlightsWithinKStops obj = new CheapestFlightsWithinKStops();
        int[][] flights = new int[][]{
                {0, 1, 100}, {1, 2, 100}, {0, 2, 500},
        };
        int kStops = 1;
        int numOfCities = 3;
        int form = 0, to = 2;

        assertThat(obj.findCheapestPrice(numOfCities, flights, form, to, kStops)).isEqualTo(200);
    }

    @Test()
    public void case3() {
        CheapestFlightsWithinKStops obj = new CheapestFlightsWithinKStops();
        int[][] flights = new int[][]{
                {0, 1, 100}, {1, 2, 100}, {0, 2, 500},
        };
        int kStops = 0;
        int numOfCities = 3;
        int form = 0, to = 2;

        assertThat(obj.findCheapestPrice(numOfCities, flights, form, to, kStops)).isEqualTo(500);
    }

    @Test()
    public void case4() {
        CheapestFlightsWithinKStops obj = new CheapestFlightsWithinKStops();
        int[][] flights = new int[][]{
                {0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}, {3, 4, 1}
        };
        int kStops = 2;
        int numOfCities = 5;
        int form = 0, to = 4;

        assertThat(obj.findCheapestPrice(numOfCities, flights, form, to, kStops)).isEqualTo(7);
    }

    @Test()
    public void case5() {
        CheapestFlightsWithinKStops obj = new CheapestFlightsWithinKStops();
        int[][] flights = new int[][]{
                {0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}
        };
        int kStops = 2;
        int numOfCities = 4;
        int form = 0, to = 3;

        assertThat(obj.findCheapestPrice(numOfCities, flights, form, to, kStops)).isEqualTo(400);
    }
}

