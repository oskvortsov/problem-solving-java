package topic.linked.list;

import data.structure.linked.list.ListNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReorderListTest {
    @Test
    public void case1() {
        ReorderList obj = new ReorderList();
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode output = new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(3))));

        obj.reorderList(input);

        compareNode(input, output);
    }

    @Test
    public void case2() {
        ReorderList obj = new ReorderList();
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode output = new ListNode(1, new ListNode(5, new ListNode(2, new ListNode(4, new ListNode(3)))));

        obj.reorderList(input);

        compareNode(input, output);
    }

    private void compareNode(ListNode node1, ListNode node2) {
        while (node1 != null) {
            assertThat(node1.val).isEqualTo(node2.val);
            node1 = node1.next;
            node2 = node2.next;
        }
    }
}
