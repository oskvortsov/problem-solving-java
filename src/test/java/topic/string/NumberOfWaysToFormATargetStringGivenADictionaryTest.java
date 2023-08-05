package topic.string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberOfWaysToFormATargetStringGivenADictionaryTest {
    NumberOfWaysToFormATargetStringGivenADictionary obj = new NumberOfWaysToFormATargetStringGivenADictionary();

    @Test()
    public void case1() {
        assertThat(obj.numWays(new String[] { "acca","bbbb","caca" }, "aba")).isEqualTo(6);
    }

    @Test()
    public void case2() {
        assertThat(obj.numWays(new String[] { "abba","baab" }, "bab")).isEqualTo(4);
    }

    @Test()
    public void case3() {
        assertThat(obj.numWays(new String[] { "ddbd","bdad","abac","abad" }, "bba")).isEqualTo(6);
    }
}

