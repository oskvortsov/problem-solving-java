package topic.string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HTMLEntityParserTest {
    @Test()
    public void case1() {
        // given
        HTMLEntityParser parser = new HTMLEntityParser();
        String givenString = "&amp; is an HTML entity but &ambassador; is not.";

        // when
        String expected = "& is an HTML entity but &ambassador; is not.";

        // then
        assertThat(parser.entityParser(givenString)).isEqualTo(expected);
    }

    @Test()
    public void case2() {
        // given
        HTMLEntityParser parser = new HTMLEntityParser();
        String givenString = "and I quote: &quot;...&quot;";

        // when
        String expected = "and I quote: \"...\"";

        // then
        assertThat(parser.entityParser(givenString)).isEqualTo(expected);
    }
}
