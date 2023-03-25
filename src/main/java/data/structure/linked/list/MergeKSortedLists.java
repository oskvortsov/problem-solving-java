package data.structure.linked.list;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode head: lists) {
            while (head != null) {
                pq.add(head);
                head = head.next;
            }
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
        }

       cur.next = null;

        return head.next;
    }

}
