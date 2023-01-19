// https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/
package data.structure.linked.list;

class MyLinkedList {
    private int size;
    private MyLinkedList head;
    private MyLinkedList next;
    private final int value;


    public MyLinkedList() {
        head = null;
        next = null;
        value = 0;
        size = 0;
    }

    public MyLinkedList(int value) {
        super();
        this.value = value;
    }

    public int get(int index) {
        if (isOutOfList(index)) {
            return -1;
        }

        MyLinkedList cur = head;

        while(index != 0 & cur != null) {
            cur = cur.next;
            index--;
        }

        return cur != null ? cur.value : -1;
    }

    public void addAtHead(int val) {
        MyLinkedList node = new MyLinkedList(val);
        node.next = head;
        head = node;
        size++;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
            return;
        }

        MyLinkedList cur = head;
        MyLinkedList node = new MyLinkedList(val);

        while (cur.next != null) cur = cur.next;
        cur.next = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (isOutOfList(index)) {
            return;
        }

        if (size == 0 || index == 0) {
            addAtHead(val);
            return;
        }

        if (size == index) {
            addAtTail(val);
            return;
        }

        MyLinkedList cur = head;
        MyLinkedList node = new MyLinkedList(val);

        while (index != 1 & cur != null) {
            cur = cur.next;
            index--;
        }

        node.next = cur.next;
        cur.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (isOutOfList(index) || size == index) {
            return;
        }

        size--;

        if (index == 0) {
            head = head.next;
            return;
        }

        MyLinkedList cur = head;

        while (index > 1) {
            cur = cur.next;
            index--;
        }

        if (cur.next.next != null) {
            cur.next = cur.next.next;
        } else {
            cur.next = null;
        }
    }

    private boolean isOutOfList(int index) {
        return index < 0 || index > size;
    }
}