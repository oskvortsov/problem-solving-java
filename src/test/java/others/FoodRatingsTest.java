package others;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FoodRatingsTest {
    @Test()
    public void case1() {
        FoodRatings rateSys = new FoodRatings(
                new String[] { "kimchi","miso","sushi","moussaka","ramen","bulgogi" },
                new String[] { "korean","japanese","japanese","greek","japanese","korean" },
                new int[] { 9,12,8,15,14,7 }
        );

        assertThat(rateSys.highestRated("korean")).isEqualTo("kimchi");
        assertThat(rateSys.highestRated("japanese")).isEqualTo("ramen");

        rateSys.changeRating("sushi", 16);
        assertThat(rateSys.highestRated("japanese")).isEqualTo("sushi");

        rateSys.changeRating("ramen", 16);
        assertThat(rateSys.highestRated("japanese")).isEqualTo("ramen");
    }

    @Test()
    public void case2() {
        FoodRatings rateSys = new FoodRatings(
                new String[] { "czopaaeyl","lxoozsbh","kbaxapl" },
                new String[] { "dmnuqeatj","dmnuqeatj","dmnuqeatj" },
                new int[] { 11,2,15 }
        );

        rateSys.changeRating("czopaaeyl", 12);
        assertThat(rateSys.highestRated("dmnuqeatj")).isEqualTo("kbaxapl");

        rateSys.changeRating("kbaxapl", 8);
        rateSys.changeRating("lxoozsbh", 5);
        assertThat(rateSys.highestRated("dmnuqeatj")).isEqualTo("czopaaeyl");
    }
}
