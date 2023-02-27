package topic.dynamic.programmic;

import org.junit.Test;
import topic.dynamic.programming.DeleteOperationForTwoStrings;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DeleteOperationForTwoStringsTest {
    @Test()
    public void case1() {
        DeleteOperationForTwoStrings obj = new DeleteOperationForTwoStrings();

        assertThat(obj.minDistance("sea", "eat")).isEqualTo(2);
        assertThat(obj.minDistance("leetcode", "etco")).isEqualTo(4);
    }
}

