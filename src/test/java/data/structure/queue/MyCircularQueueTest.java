package data.structure.queue;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MyCircularQueueTest {
    @Test()
    public void case1() {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        assertThat(myCircularQueue.enQueue(1)).isTrue(); // return True
        assertThat(myCircularQueue.Rear()).isEqualTo(1);
        assertThat(myCircularQueue.Front()).isEqualTo(1);
        assertThat(myCircularQueue.enQueue(2)).isTrue(); // return True
        assertThat(myCircularQueue.enQueue(3)).isTrue(); // return True
        assertThat(myCircularQueue.enQueue(4)).isFalse(); // return False
        assertThat(myCircularQueue.Rear()).isEqualTo(3);     // return 3
        assertThat(myCircularQueue.isFull()).isTrue();   // return True
        assertThat(myCircularQueue.deQueue()).isTrue();  // return True
        assertThat(myCircularQueue.enQueue(4)).isTrue(); // return True
        assertThat(myCircularQueue.Rear()).isEqualTo(4);     // return 4
    }

    @Test()
    public void case2() {
        MyCircularQueue q = new MyCircularQueue(3);
        assertThat(q.enQueue(1)).isTrue();
        assertThat(q.Rear()).isEqualTo(1);
        assertThat(q.Front()).isEqualTo(1);

        assertThat(q.enQueue(2)).isTrue();
        assertThat(q.Rear()).isEqualTo(2);
        assertThat(q.Front()).isEqualTo(1);

        q.enQueue(3);
        assertThat(q.Rear()).isEqualTo(3);
        assertThat(q.Front()).isEqualTo(1);

        assertThat(q.isFull()).isTrue();
        assertThat(q.deQueue()).isTrue();
        assertThat(q.Rear()).isEqualTo(3);
        assertThat(q.Front()).isEqualTo(2);
    }

    @Test()
    public void case3() {
        MyCircularQueue q = new MyCircularQueue(86);
        q.enQueue(1);
        q.deQueue();

        q.enQueue(2);
        q.enQueue(3);
        assertThat(q.Front()).isEqualTo(2);
        assertThat(q.Rear()).isEqualTo(3);
    }
}