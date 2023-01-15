/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

public class DoublyLinkedList<T> {
    private class Node {
        public Node left;
        public Node right;
        T value;

        Node(T val, Node left, Node right) {
            this.value = val;
            this.left = left;
            this.right = right;
        }
    }

    Node front = null;
    Node tail = null;

    public void push(T val) {
        var node = new Node(val, tail, null);
        if (front == null) {
            front = tail = node;
        } else {
            tail.right = node;
            tail = node;
        }
    }

    public T pop() {
        if (tail == null) return null;

        var node = tail;

        tail = tail.left;
        if (tail == null) front = null;

        return node.value;
    }

    public void unshift(T val) {
        var node = new Node(val, null, front);

        if (front == null) {
            front = tail = node;
        } else {
            front.left = node;
            front = node;
        }
    }

    public T shift() {
        if (front == null) return null;

        var node = front;

        front = front.right;
        if (front == null) tail = null;

        return node.value;
    }

}