package day_6;

class CircularLinkedList {
	Node head;
	Node tail;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;

		}
	}

	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		// if list is empty
		if (tail == null) {
			tail = newNode;
			tail.next = tail;
			return;

		}

		newNode.next = tail.next;
		tail.next = newNode;
		tail = newNode;

	}

	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		if (tail == null) {
			tail.next = newNode;
			tail.next = tail;
			return;

		}
		newNode.next = tail.next;
		tail.next = newNode;
	}

	public void insertAtPosition(int position, int data) {

		Node newNode = new Node(data);
		if (position <= 0) {
			System.out.println("Invalid position");
			return;
		}
		// Insert at beginning
		if (position == 1) {
			insertAtBeginning(data);
			return;
		}

		// if list is empty
		if (head == null) {
			System.out.println("Invalid position");
			return;
		}
		Node current = head;
		// Move to the node before the required position

		for (int i = 1; i < position - 1; i++) {
			current = current.next;

			// Position does not exist
			if (current == head) {
				System.out.println("Invalid Position");
				return;
			}
		}
		// connect new node
		newNode.next = current.next;
		current.next = newNode;

		// If inserted after tail, update tail
		if (current == tail) {
			tail = newNode;
		}
	}

	public void deleteAtEnd() {

		Node current = tail.next;
		while (current.next != tail) {
			current = current.next;

		}
		current.next = tail.next;
	}

	public void deleteAtBeginning() {
		// List is empty
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		// Only one node
		if (head == tail) {
			head = null;
			tail = null;
			return;
		}
		// Move head to the next node
		head = head.next;
		// Maintain circular connection
		tail.next = head;

	}

	public void display() {
		Node current = tail.next;
		do {
			System.out.println(current.data + "->");
			current = current.next;

		} while (current != tail.next);
		System.out.println("null");
	}

}

public class CircularLinkedListDemo {

	public static void main(String[] args) {
		CircularLinkedList circularLinkedList = new CircularLinkedList();
		circularLinkedList.insertAtEnd(10);
		circularLinkedList.insertAtEnd(20);
		circularLinkedList.insertAtEnd(30);
		circularLinkedList.insertAtEnd(40);
		circularLinkedList.insertAtEnd(50);
		circularLinkedList.insertAtBeginning(5);
		circularLinkedList.insertAtPosition(2, 25);
		circularLinkedList.display();

	}

}
