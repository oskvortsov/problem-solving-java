package topic.string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FindTheIndexOfTheFirstOccurrenceInAStringTest {
    FindTheIndexOfTheFirstOccurrenceInAString obj = new FindTheIndexOfTheFirstOccurrenceInAString();

    @Test()
    public void case1() {
        assertThat(obj.strStr("sadbutsad", "sad")).isEqualTo(0);
        assertThat(obj.strStr("hello", "ll")).isEqualTo(2);
    }
}

