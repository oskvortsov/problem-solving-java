package data.structure.linked.list;

import org.junit.Test;
import topic.linked.list.ReverseLinkedListTwo;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseLinkedListTwoTest {
    @Test
    public void case1() {
        // given
        ReverseLinkedListTwo obj = new ReverseLinkedListTwo();
        ListNode given = generateList(new int[] { 1, 2, 3, 4, 5 });

        // when
        ListNode reverse = obj.reverseBetween(given, 2, 4);

        // then
        ListNode expected = generateList(new int[] { 1, 4, 3, 2, 5 });
        assertThat(reverse).isEqualTo(expected);
    }

    @Test
    public void case2() {
        // given
        ReverseLinkedListTwo obj = new ReverseLinkedListTwo();
        ListNode given = generateList(new int[] { 1, 2, 3, 4, 5 });

        // when
        ListNode reverse = obj.reverseBetween(given, 0, 5);

        // then
        ListNode expected = generateList(new int[] { 5, 4, 3, 2, 1 });;
        assertThat(reverse).isEqualTo(expected);
    }

    @Test
    public void case3() {
        // given
        ReverseLinkedListTwo obj = new ReverseLinkedListTwo();
        ListNode given = generateList(new int[] { 1, 2, 3, 4, 5 });;

        // when
        ListNode reverse = obj.reverseBetween(given, 3, 5);

        // then
        ListNode expected = generateList(new int[] { 1, 2, 5, 4, 3 });
        assertThat(reverse).isEqualTo(expected);
    }

    private ListNode generateList(int[] items) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        for (int val: items) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }

        return head.next;
    }
}