package data.structure.linked.list;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        this(x);
        this.next = next;
    }
}
