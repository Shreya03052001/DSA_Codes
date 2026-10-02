package day_6;

class DoublyLinkedList {
	Node tail;
	Node head;

	class Node {

		int data;
		Node next;
		Node previous;

		public Node(int data) {
			this.data = data;
			this.next = null;
			this.previous = null;

		}
	}

	public void insertAtEnd(int data) {

		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}

		// traverse upto last node
		tail.next = newNode;
		newNode.previous = tail;
		tail = newNode; // Don't forget to remember

	}

	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		}

		head.previous = newNode;
		newNode.next = head;
		head = newNode;

	}

	public void insertAtPosition(int position, int data) {
		Node temp;
		temp = head;

		Node newNode = new Node(data);
		for (int i = 0; i < position - 1; i++) {
			temp = temp.next;

		}
		newNode.next = temp.next;
		newNode.previous = temp;

		temp.next.previous = newNode;
		temp.next = newNode;

	}

	public void deleteAtEnd() {
		if (head == null) {
			System.out.println("List is empty");
			return;

		}
		if (head == tail) {
			head = null;
			tail = null;
			return;
		}
		tail = tail.previous;
		tail.next = null;
	}

	public void deleteAtBeginning() {
		// If list is empty
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		// If only one node is present
		if (head == tail) {
			head = null;
			tail = null;
			return;
		}
		// Move head to next node
		head.next = head;
		// Remove previous link
		head.previous = null;
	}

	public void deleteAtPosition(int position) {

	    if (head == null) {
	        System.out.println("List is empty");
	        return;
	    }

	    if (position <= 0) {
	        System.out.println("Invalid position");
	        return;
	    }

	    // Delete first node
	    if (position == 1) {
	        deleteAtBeginning();
	        return;
	    }

	    Node temp = head;

	    // Move temp to the node at given position
	    for (int i = 1; i < position; i++) {
	        temp = temp.next;

	        if (temp == null) {
	            System.out.println("Invalid position");
	            return;
	        }
	    }

	    // Delete last node
	    if (temp == tail) {
	        deleteAtEnd();
	        return;
	    }

	    // Connect previous node to next node
	    temp.previous.next = temp.next;

	    // Connect next node to previous node
	    temp.next.previous = temp.previous;
	}
	public void displayForward() {
		Node temp = head;

		while (temp != tail.next) {
			System.out.println(temp.data);
			temp = temp.next;

		}

		/*
		 * Node temp = head; while (temp != null) { System.out.println(temp.data + "->"
		 * + " "); temp = temp.next; }
		 * 
		 * System.out.println("null");
		 */

	}

	public void displayBackward() {
		Node temp = tail;
		while (temp != null) {
			System.out.print(temp.data + "->" + " ");
			temp = temp.previous;
		}
		System.out.print("" + "" + "");
	}

	/*
	 * Node temp = head; // stop at last node while (temp != null) { temp =
	 * temp.next; }
	 * 
	 * while (temp != null) { System.out.println(temp.data + "->" + " ");
	 * 
	 * }
	 */
}

public class DoublyLinkedListDemo {

	public static void main(String[] args) {
		DoublyLinkedList doublylinkedList = new DoublyLinkedList();

		doublylinkedList.insertAtEnd(10);
		doublylinkedList.insertAtEnd(20);
		doublylinkedList.insertAtEnd(30);
		doublylinkedList.insertAtEnd(40);
		doublylinkedList.insertAtBeginning(25);
		doublylinkedList.insertAtPosition(2, 45);
		doublylinkedList.deleteAtEnd();
	//doublylinkedList.deleteAtBeginning();
		//doublylinkedList.deleteAtPosition(2);
		doublylinkedList.displayForward();
		doublylinkedList.displayBackward();

	} 

}
