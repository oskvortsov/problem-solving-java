package topic.dynamic.programmic;

import org.junit.Test;
import topic.dynamic.programming.MinimumASCIIDeleteSumForTwoStrings;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MinimumASCIIDeleteSumForTwoStringsTest {
    @Test()
    public void case1() {
        MinimumASCIIDeleteSumForTwoStrings obj = new MinimumASCIIDeleteSumForTwoStrings();
        assertThat(obj.minimumDeleteSum("fzokfmazrbh", "nkvakivl")).isEqualTo(1650);
        assertThat(obj.minimumDeleteSum("sea", "eat")).isEqualTo(231);
        assertThat(obj.minimumDeleteSum("delete", "leet")).isEqualTo(403);
        assertThat(obj.minimumDeleteSum("leetcode", "leer")).isEqualTo(641);
        assertThat(obj.minimumDeleteSum("xnbteodleejrzeo", "gaouojqkkk")).isEqualTo(2255);
    }
}

