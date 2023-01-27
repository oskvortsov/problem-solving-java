package data.structure.linked.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node random;

    public Node(int val) {
        this.val = val;
    }
};

class LinkedListsTasks {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        ListNode cur = head;

        // 1 -> 1 -> 2 -> 3 - > 3
        while (tmp != null) {
            ListNode next = tmp.next;
            tmp = next;

            if (next != null && next.val == cur.val) {
                continue;
            }

            cur.next = next;
            cur = next;
        }

        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> table = new HashSet<>();

        ListNode  cur = headA;

        while (cur != null) {
            table.add(cur);
            cur = cur.next;
        }

        cur = headB;

        while (cur != null) {
            if (table.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pointA = headA;
        ListNode pointB = headB;

        while (pointA != pointB) {
            if (pointA == null) {
                pointA = headB;
            } else {
                pointA = pointB.next;
            }

            if (pointB == null) {
                pointB = headA;
            } else {
                pointB = pointB.next;
            }
        }

        return pointA;
    }

    // https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        do {
            if (fast == null || fast.next == null || fast.next.next == null) {
                return null;
            }

            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(0), cur = node;
        node.next = head;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return node.next;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode even = new ListNode(-1), odd = new ListNode(-1), cur = head;
        ListNode hEven = even, hOdd = odd;
        boolean isOdd = true;

        while (cur != null) {
            if (isOdd) {
                odd.next = cur;
                odd = cur;
                isOdd = false;
            } else {
                even.next = cur;
                even = cur;
                isOdd = true;
            }

            cur = cur.next;
        }

        even.next = null;
        odd.next = null;

        head = hOdd.next;

        cur = head;

        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = hEven.next;

        return head;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head, even = odd.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public ListNode findHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    // 1 -> 2 -> 2 -> 1
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, prev = null, next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode midHead = reverseList(findHalf(head).next);

        while (midHead != null) {
            if (midHead.val != head.val) {
                System.out.println(midHead.val);
                System.out.println(head.val);
                return false;
            }

            midHead = midHead.next;
            head = head.next;
        }

        return true;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode head = new ListNode(-1), cur = head;;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }

            cur = cur.next;
        }

        if (list1 != null) cur.next = list1;
        if (list2 != null) cur.next = list2;

        return head.next;
    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1, cur = l1;
        int buffer = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + buffer;
            buffer = 0;

            if (sum > 9) {
                buffer = 1;
                sum -= 10;
            }
            System.out.println(sum);

            cur.val = sum;
            if (cur.next != null) cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode next = l1 == null ? l2 : l1;
        cur.next = next;

        while (next != null && buffer > 0) {
            int sum = next.val + buffer;
            buffer = 0;

            if (sum > 9) {
                buffer = sum % 10;
                sum /= 10;
            }

            next.val = sum;
            next = next.next;
        }

        return head;
    }

    public static Node flatten(Node head) {
        if (head == null) return head;

        Node child = flatten(head.child);
        Node next = flatten(head.next);

        if (child != null) {
            head.next = child;
            child.prev = head;
            head.child = null;

            while (child.next != null) {
                child = child.next;
            }

            child.next = next;
            if (next != null) next.prev = child;
        }

        return head;
    }

    // https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1229/
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> nodeMap = new HashMap<>();
        Node tmp = head;


        while (tmp != null) {
            nodeMap.put(tmp, new Node(tmp.val));
            tmp = tmp.next;
        }

        tmp = head;
        while (tmp != null) {
            Node copyNode = nodeMap.get(tmp);
            copyNode.next = nodeMap.get(tmp.next);
            copyNode.random = nodeMap.get(tmp.random);
            tmp = tmp.next;
        }

        return nodeMap.get(head);
    }

    // https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int size = 0;

        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            size++;
        }

        k %= size;

        if (k == 0) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < k; i++) fast = fast.next;

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode result = slow.next;
        slow.next = null;
        fast.next = head;

        return result;
    }
}
