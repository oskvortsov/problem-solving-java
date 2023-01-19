package data.structure.linked.list;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MyLinkedListTest {
    @Test()
    public void addToHeadTest() {
        MyLinkedList obj = new MyLinkedList();
        assertThat(obj.get(0)).isEqualTo(-1);

        obj.addAtHead(1);
        assertThat(obj.get(0)).isEqualTo(1);

        obj.addAtHead(2);
        assertThat(obj.get(0)).isEqualTo(2);
        assertThat(obj.get(1)).isEqualTo(1);
    }

    @Test()
    public void addAtIndexTest() {
        MyLinkedList obj = new MyLinkedList();
        // empty list\
        obj.addAtIndex(-1, 1);
        obj.addAtIndex(1, 1);
        assertThat(obj.get(0)).isEqualTo(-1);


        obj.addAtIndex(0, 3);
        obj.addAtHead(2);
        obj.addAtHead(1);
        // 1 -> 2 -> 3

        assertThat(obj.get(0)).isEqualTo(1);
        assertThat(obj.get(1)).isEqualTo(2);
        assertThat(obj.get(2)).isEqualTo(3);

        // 1 -> 2 -> 3
        obj.addAtIndex(1, 11);
        assertThat(obj.get(1)).isEqualTo(11);
        assertThat(obj.get(2)).isEqualTo(2);
        // 1 -> 11 -> 2 -> 3

        // 1 -> 11 -> 2 -> 3
        obj.addAtIndex(3, 22);
        assertThat(obj.get(2)).isEqualTo(2);
        assertThat(obj.get(3)).isEqualTo(22);
        // 1 -> 11 -> 2 -> 22 -> 3

        // 1 -> 11 -> 2 > 22 -> 3
        obj.addAtIndex(5, 33);
        assertThat(obj.get(4)).isEqualTo(3);
        assertThat(obj.get(5)).isEqualTo(33);
        // 1 -> 11 -> 2 > 22 -> 3 -> 33

        // 1 -> 11 -> 2 > 22 -> 3 -> 33
        obj.addAtIndex(6, 5);
        assertThat(obj.get(6)).isEqualTo(5);
        // 1 -> 11 -> 2 > 22 -> 3 -> 33 -> 5
    }

    @Test()
    public void addAtTailTest() {
        MyLinkedList obj = new MyLinkedList();

        obj.addAtTail(1);
        obj.addAtTail(2);
        obj.addAtTail(3);
        // 1 -> 2 -> 3
        assertThat(obj.get(0)).isEqualTo(1);
        assertThat(obj.get(1)).isEqualTo(2);
        assertThat(obj.get(2)).isEqualTo(3);
    }

    @Test()
    public void deleteAtIndexTest() {
        MyLinkedList obj = new MyLinkedList();
        //empty
        obj.deleteAtIndex(-1);
        obj.deleteAtIndex(1);
        assertThat(obj.get(0)).isEqualTo(-1);
        // empty

        obj.addAtHead(1);
        obj.addAtTail(2);
        obj.addAtTail(22);
        obj.addAtTail(3);
        obj.addAtTail(33);
        // 1 -> 2 -> 22 > 3 -> 33

        assertThat(obj.get(0)).isEqualTo(1);
        assertThat(obj.get(1)).isEqualTo(2);
        assertThat(obj.get(2)).isEqualTo(22);
        assertThat(obj.get(3)).isEqualTo(3);
        assertThat(obj.get(4)).isEqualTo(33);

        // 1 -> 2 -> 22 > 3 -> 33
        obj.deleteAtIndex(2);
        // 1 -> 2 - > 3 -> 33

        // 1 -> 2 - > 3 -> 33
        obj.deleteAtIndex(3);
        // 1 -> 2 - > 3

        assertThat(obj.get(0)).isEqualTo(1);
        assertThat(obj.get(1)).isEqualTo(2);
        assertThat(obj.get(2)).isEqualTo(3);

        // 1 -> 2 - > 3
        obj.deleteAtIndex(0);
        // 2 - > 3
        assertThat(obj.get(0)).isEqualTo(2);
    }

    @Test()
    public void getTest() {
        MyLinkedList obj = new MyLinkedList();
        assertThat(obj.get(-1)).isEqualTo(-1);
        assertThat(obj.get(1)).isEqualTo(-1);

        obj.addAtHead(1);
        assertThat(obj.get(0)).isEqualTo(1);

        obj.addAtHead(2);
        assertThat(obj.get(0)).isEqualTo(2);
        assertThat(obj.get(1)).isEqualTo(1);
    }

//    [
//            "MyLinkedList",
//            "addAtHead", 1
//            "deleteAtIndex", 1
//            "deleteAtIndex", 1
//            "addAtTail", 7
//            "deleteAtIndex", 2
//            "addAtTail", 1
//            "addAtTail", 8
//            "addAtHead", 2
//            "addAtIndex", [5,2]
//            "addAtTail", 7
//            "get" 2
//    ]

    @Test()
    public void case1Test() {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1); // 1
        obj.deleteAtIndex(1); // 1
        obj.deleteAtIndex(1); // 1
        obj.addAtTail(7); // 1 -> 7
        obj.deleteAtIndex(2); // 1 -> 7
        obj.addAtTail(1); // 1 -> 7 -> 1
        obj.addAtTail(8); // 1 -> 7 -> 1 -> 8
        obj.addAtHead(2); // 2 -> 1 -> 7 -> 1 -> 8
        obj.addAtIndex(5, 2); // 2 -> 1 -> 7 -> 1 -> 8 -> 2
        obj.addAtTail(7); // 2 -> 1 -> 7 -> 1 -> 8 -> 2 -> 7
        obj.get(2); // 2
    }
}
