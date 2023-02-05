package data.structure.queue;

public class MyCircularQueue {
    private int head = -1;
    private int tail = -1;
    private int size = 0;
    private final int capacity;
    private final int[] data;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.data = new int[k];
    }

    // insert
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        if (tail == -1) {
            head = 0;
            tail = 0;
        } else {
            tail = tail + 1 == capacity ? 0 : tail + 1;
        }

        data[tail] = value;
        size++;

        return true;
    }

    // pop
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        head = head + 1 == capacity ? 0 : head + 1;
        size--;

        return true;
    }

    // first item
    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return data[head];
    }

    // last item
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return data[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
