package data.structure.stack;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EvaluateReversePolishNotationTest {
    @Test()
    public void case1() {
        EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
        assertThat(obj.evalRPN(new String[] {"2","1","+","3","*" })).isEqualTo(9);
        assertThat(obj.evalRPN(new String[] {"4","13","5","/","+"})).isEqualTo(6);
        assertThat(obj.evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"})).isEqualTo(22);
    }
}
