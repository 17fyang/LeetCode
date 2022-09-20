package Q600_700;

/**
 * @Description:
 * @Author: 乌鸦坐飞机亠
 * @Date: 2022/8/25 23:27
 */
public class Q622 {
    private int max;
    private int size = 0;
    private Node head;
    private Node tail;

    public static void main(String[] args) {
        Q622 queue = new Q622(2);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.deQueue();
        queue.enQueue(3);
        queue.deQueue();
        queue.enQueue(3);
        queue.deQueue();
        queue.enQueue(3);
        queue.deQueue();
        System.out.println(queue.Front());
    }

    public Q622(int k) {
        this.max = k;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (size >= max) {
            return false;
        }

        Node n = new Node(value);
        if (size == 0) {
            n.pre = n;
            n.next = n;
            this.head = n;
            this.tail = n;
            this.size++;
            return true;
        }

        n.pre = this.tail;
        this.tail.next = n;
        this.tail = n;
        this.size++;
        return true;
    }

    public boolean deQueue() {
        if (size <= 0) {
            return false;
        }

        if (size == 1) {
            this.size = 0;
            this.head = null;
            this.tail = null;
            return true;
        }

        this.head.next.pre = this.tail;
        this.tail.next = this.head.next;
        this.head = this.head.next;
        this.size--;
        return true;
    }

    public int Front() {
        if (this.size <= 0) {
            return -1;
        } else {
            return this.head.value;
        }
    }

    public int Rear() {
        if (this.size <= 0) {
            return -1;
        } else {
            return this.tail.value;
        }
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public boolean isFull() {
        return this.size >= max;
    }

    static class Node {
        int value;
        Node next;
        Node pre;

        public Node(int value) {
            this.value = value;
        }
    }
}
