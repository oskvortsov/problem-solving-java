package topic.array;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindCommonCharactersTest {
    @Test
    public void case1() {
        FindCommonCharacters obj = new FindCommonCharacters();
        assertThat(obj.commonChars(new String[]{"bella", "label", "roller"})).isEqualTo(List.of("e", "l", "l"));
    }
}
