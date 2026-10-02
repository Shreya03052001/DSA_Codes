package day_4;

public class CircularQueue {

	int queue[];
	int front;

	int rear;
	int maxSize;
	int count;

	public CircularQueue(int size) {
		this.maxSize = size;
		queue = new int[maxSize];
		front = 0;
		rear = -1;
		count = 0;
	}

	public void enque(int data) {

		System.out.println("Queue is full,cannot accomodate...");
		rear = (rear + 1) % maxSize;
		queue[rear] = data;
		count++;

	}

	public void deque() {
		int data = queue[front];
		front = (front + 1) % maxSize;
		// return data;
		count--;

	}

	public int peek() {

		return queue[front];
	}

	public void display() {
		for (int i = front; i <= rear; i++) {

			System.out.println(queue[i]);
		}

	}

	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue(5);

		queue.enque(10);
		queue.enque(20);
		queue.enque(30);
		queue.enque(40);
		queue.enque(50);
		queue.deque();
		queue.deque();
		queue.display();

		// queue.deque();
		// queue.deque();

		System.out.println("Going to process: " + queue.peek());

	}

}
