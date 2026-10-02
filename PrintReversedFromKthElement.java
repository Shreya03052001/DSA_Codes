package day_4;

import java.util.Stack;

public class PrintReversedFromKthElement {

    class CircularQueue2 {

        int queue[];
        int front;
        int rear;
        int maxSize;
        int count;

        public CircularQueue2(int size) {
            this.maxSize = size;
            queue = new int[maxSize];

            front = 0;
            rear = -1;
            count = 0;
        }

        // Insert element into circular queue
        public void enque(int data) {

            if (count == maxSize) {
                System.out.println("Queue is full, cannot accommodate...");
                return;
            }

            rear = (rear + 1) % maxSize;
            queue[rear] = data;
            count++;
        }

        // Remove element from circular queue
        public int deque() {

            if (count == 0) {
                System.out.println("Queue is Empty");
                return -1;
            }

            int data = queue[front];

            front = (front + 1) % maxSize;
            count--;

            return data;
        }

        // See front element
        public int peek() {

            if (count == 0) {
                System.out.println("Queue is empty");
                return -1;
            }

            return queue[front];
        }

        // Display queue
        public void display() {

            if (count == 0) {
                System.out.println("Queue is empty");
                return;
            }

            int index = front;

            for (int i = 0; i < count; i++) {
                System.out.print(queue[index] + " ");
                index = (index + 1) % maxSize;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        PrintReversedFromKthElement obj =
                new PrintReversedFromKthElement();

        CircularQueue2 q = obj.new CircularQueue2(7);

        // Insert elements
        q.enque(10);
        q.enque(20);
        q.enque(30);
        q.enque(40);
        q.enque(50);
        q.enque(60);
        q.enque(70);

        int k = 4;

        Stack<Integer> s = new Stack<>();

        // Take first k elements and push into stack
        for (int i = 0; i < k; i++) {
            s.push(q.deque());
        }

        // Put the k elements back.
        // Stack reverses their order.
        while (!s.isEmpty()) {
            q.enque(s.pop());
        }

        // Number of elements that were originally after
        // the first k elements
        int remaining = q.count - k;

        // Move remaining elements from front to back
        for (int i = 0; i < remaining; i++) {
            q.enque(q.deque());
        }

        // Display final queue
        q.display();
    }
}