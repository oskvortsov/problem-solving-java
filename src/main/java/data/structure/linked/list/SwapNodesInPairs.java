package data.structure.linked.list;

// https://leetcode.com/problems/swap-nodes-in-pairs/description/
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        ListNode cur = head;
        ListNode next = head.next;
        ListNode prev = null;

        while (next != null) {
            cur.next = next.next;
            next.next = cur;

            if (prev == null) {
                prev = cur;
            } else {
                prev.next = next;
                prev = cur;
            }

            cur = cur.next;
            next = cur != null ? cur.next : null;
        }

        return newHead;
    }
}
