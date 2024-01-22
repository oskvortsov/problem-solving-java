package topic.linked.list;

// https://leetcode.com/problems/reorder-list/

import data.structure.linked.list.ListNode;

public class ReorderList {
    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head, next = cur.next;

        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }

        cur.next = prev;
        return cur;
    }

    private ListNode middle(ListNode head) {
        ListNode fast = head, slow = head;


        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }

        ListNode mid = middle(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;

        ListNode cur = head;

        while (tail != null) {
            ListNode tNext = tail.next;
            ListNode cNext = cur.next;

            cur.next = tail;
            tail.next = cNext;
            tail = tNext;
            cur = cNext;
        }
    }
}
