package topic.linked.list;

import data.structure.linked.list.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        byte rest = 0;

        while (l1 != null || l2 != null || rest != 0) {
            int sum = rest;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (sum > 9) {
                rest = 1;
                sum %= 10;
            } else {
                rest = 0;
            }

            cur.next = new ListNode(sum);
            cur = cur.next;
        }

        return newHead.next;
    }
}
