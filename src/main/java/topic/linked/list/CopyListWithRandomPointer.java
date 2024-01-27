package topic.linked.list;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node cur = head;
        Node newHead = new Node(0);
        Node tmp = newHead;


        while (cur !=  null) {
            Node node = new Node(cur.val);
            tmp.next = node;
            map.put(cur, node);

            cur = cur.next;
            tmp = tmp.next;
        }

        tmp = newHead.next;
        cur = head;
        while (cur != null) {
            tmp.random = map.get(cur.random);
            cur = cur.next;
            tmp = tmp.next;
        }

        return newHead.next;
    }
}
