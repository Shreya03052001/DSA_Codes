package day_4;

public class Queue {

	private int queue[];
	private int front;
	private int rear;
	private int maxSize;

	public Queue(int size) {
		this.maxSize = size;
		this.queue = new int[maxSize];
		this.front = 0;
		this.rear = -1;

	}

	public void enque(int data) {
		if (rear == maxSize - 1) {

			System.out.println("Queue is full,cannot process anymore...");
			return;
		}
		rear = rear + 1;
		queue[rear] = data;
	}

	public int deque() {
		if (front> rear) {

			System.out.println("Queue is empty");
			return -1;
		}
		int data = queue[front];
		front++;
		return data;
	}

	public void display() {
		System.out.println();
		for (int i = front; i <= rear; i++) {
			System.out.print(queue[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Queue queue = new Queue(5);

		queue.enque(10);
		queue.enque(20);
		queue.enque(30);
		queue.enque(40);
		queue.enque(50);
		queue.display();

		System.out.println("Deque: " + queue.deque());
		System.out.println("Deque: " + queue.deque());
		System.out.println("Deque: " + queue.deque());
		System.out.println("Deque: " + queue.deque());
		System.out.println("Deque: " + queue.deque());
		System.out.println("Deque: " + queue.deque());
		queue.display();
		

	}

}
