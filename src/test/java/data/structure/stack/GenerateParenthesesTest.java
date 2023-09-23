package data.structure.stack;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GenerateParenthesesTest {
    @Test
    public void case1() {
        GenerateParentheses obj = new GenerateParentheses();
        assertThat(obj.generateParenthesis(3)).isEqualTo(List.of("((()))","(()())","(())()","()(())","()()()"));
    }

    @Test
    public void case2() {
        GenerateParentheses obj = new GenerateParentheses();
        assertThat(obj.generateParenthesis(1)).isEqualTo(List.of("()"));
    }
}
