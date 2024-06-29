package topic.linked.list;

import data.structure.linked.list.ListNode;

import java.util.Arrays;

public class ReverseLinkedListTwo {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode l, r, cur = head;

        for (int i = 0; i < right; i++) {
            if (i < left) l = cur;
            cur = cur.next;
        }
        r = cur;

        return head;
    }

}
