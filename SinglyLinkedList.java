package day_5;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;

	}
}

class LinkedList {
	Node head;

	int count;

	public void addAtEnd(int data) {

		Node newNode = new Node(data);
		count++;
		if (head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}

	public void addAtBeginning(int data) {
		count++;
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}

		newNode.next = head;
		head = newNode;
	}

	public void addAtPosition(int position, int data) {
		Node newNode = new Node(data);

		Node temp = head;
		for (int i = 0; i < position - 1; i++) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		count++;

		// position=0
		/*
		 * if (position == 0) { addAtBeginning(data); return; }
		 * 
		 * if (position < 0 || position > count) {
		 * System.out.println("Cannot add in position"); return; }
		 * 
		 * if (position == count) { addAtEnd(data); return; } Node temp = head; for (int
		 * i = 0; i < position - 1; i++) { temp = temp.next; } newNode.next = temp.next;
		 * temp.next = newNode; count++;
		 */
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		// temp.next = newNode;
	}

	public void deleteAtEnd() {
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;

		}
		temp.next = null;
	}

	public void deleteAtFirst() {

	}

}

public class SinglyLinkedList {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();

		linkedList.addAtEnd(10);
		linkedList.addAtEnd(20);
		linkedList.addAtEnd(30);
		linkedList.addAtEnd(40);
		linkedList.addAtEnd(50);
		linkedList.addAtEnd(90);

		linkedList.addAtBeginning(5);
		linkedList.addAtPosition(3, 25);

		// linkedList.deleteAtEnd();
		// linkedList.deleteAtFirst();
		linkedList.display();
	}
}
