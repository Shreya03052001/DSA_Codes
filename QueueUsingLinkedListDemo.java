package day_6;

class QueueUsingLinkedList {

	Node front;
	Node rear;

	class Node {

		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void enque(int data) {
		Node newNode = new Node(data);
		if (front == null) {
			front = rear = newNode;
			return;

		}

		rear.next = newNode;
		rear = newNode;

	}

	public int deque() {

		int data = front.data;
		front = front.next;
		if (front == null) {
			rear = null;
		}

		return data;

	}

	public void empty() {
		if (front == null) {
			System.out.println("Queue is empty");
			return;

		}
	}

	public void display() {
		Node temp = front;
		if (front == null) {
			System.out.println("Queue is empty");

		}
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public char[] peek() {
		// TODO Auto-generated method stub
		return null;
	}
}

public class QueueUsingLinkedListDemo {

	public static void main(String[] args) {
		QueueUsingLinkedList queue = new QueueUsingLinkedList();
		queue.enque(10);
		queue.enque(20);
		queue.enque(30);
		queue.enque(40);
		queue.deque();
		queue.deque();
		queue.deque();
		
		System.out.println("Element remove at front: "+queue.deque());

		queue.display();
		//queue.empty();
	
	}

}
