package data.structure.trie;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/explore/learn/card/trie/149/practical-application-ii/1057/
public class MaximumXorOfTwoNumbersTest {
    @Test()
    public void case1() {
        MaximumXorOfTwoNumbers obj = new MaximumXorOfTwoNumbers();
//        assertThat(obj.findMaximumXOR(new int[] { 3,10,5,25,2,8 })).isEqualTo(28);
        assertThat(obj.findMaximumXOR(new int[] { 14,70,53,83,49,91,36,80,92,51,66,70 })).isEqualTo(127);
    }
}
