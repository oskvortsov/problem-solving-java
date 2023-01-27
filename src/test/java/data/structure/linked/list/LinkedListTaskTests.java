package data.structure.linked.list;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LinkedListTaskTests {
    @Test
    public void rotateRightCase1() {
        LinkedListsTasks obj = new LinkedListsTasks();
        ListNode head = new ListNode(1, new ListNode(2));
        ListNode res = obj.rotateRight(head, 1);

        assertThat(res.val).isEqualTo(2);
        assertThat(res.next.val).isEqualTo(1);
    }

    @Test
    public void rotateRightCase2() {
        LinkedListsTasks obj = new LinkedListsTasks();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode res = obj.rotateRight(head, 2);

        assertThat(res.val).isEqualTo(4);
        assertThat(res.next.val).isEqualTo(5);
        assertThat(res.next.next.val).isEqualTo(1);
        assertThat(res.next.next.next.val).isEqualTo(2);
        assertThat(res.next.next.next.next.val).isEqualTo(3);
        assertThat(res.next.next.next.next.next).isEqualTo(null);
    }

    @Test
    public void rotateRightCase3() {
        LinkedListsTasks obj = new LinkedListsTasks();
        ListNode head = new ListNode(1);
        ListNode res = obj.rotateRight(head, 99);

        assertThat(res.val).isEqualTo(1);
        assertThat(res.next).isEqualTo(null);
    }
}
