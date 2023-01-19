package topic.array;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.List;

public class FindAllNumbersDisappearedSolutionTest {
   private FindAllNumbersDisappearedSolution solver = new FindAllNumbersDisappearedSolution();

   @Test()
   public void case1() {
      int[] input = new int[] { 4,3,2,7,8,2,3,1 };
      int[] input2 = new int[] { 4,3,2,7,8,2,3,1 };
      List<Integer> output = List.of(5,  6);

      assertThat(solver.findDisappearedNumbers(input)).isEqualTo(output);
      assertThat(solver.findDisappearedNumbers2(input2)).isEqualTo(output);
   }

   @Test()
   public void case2() {
      int[] input = new int[] { 1, 1 };
      int[] input2 = new int[] { 1, 1 };
      List<Integer> output = List.of(2);

      assertThat(solver.findDisappearedNumbers(input)).isEqualTo(output);
      assertThat(solver.findDisappearedNumbers2(input2)).isEqualTo(output);
   }
}
