package topic.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TopKFrequentElementsTest {
    @Test
    public void case1() {
        TopKFrequentElements tkfe = new TopKFrequentElements();
        assertThat(tkfe.topKFrequent(new int[] { 1,1,1,2,2,3 }, 2)).isEqualTo(new int[] { 1, 2 });
    }
}
