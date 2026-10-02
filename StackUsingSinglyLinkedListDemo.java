package day_6;

class StackUsingSinglyLinkedList{
	Node head;
	Node top;
class Node {

	int data;
	Node next;

	public Node(int data) {

		this.data = data;
		this.next = null;

	}
	
	
}
	public void push(int data) {
		Node newNode = new Node(data);
		if (top == null) {
			top = newNode;
			return;

		}
		newNode.next = top;
		top = newNode;

	}

	public int pop() {

		if (top == null) {
			System.out.println("Stack is empty");
			return -1;
		}
		Node temp = top;
		top = top.next;
		int data = temp.data;
		temp.next = null;
		return data;
	}

	public int peek() {
		if (top == null) {

			return -1;
		}
		return top.data;
	}

	public void display() {
		Node temp = top;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;

		}
		System.out.println();

	}
	}


public class StackUsingSinglyLinkedListDemo {

	public static void main(String[] args) {
		StackUsingSinglyLinkedList stack = new StackUsingSinglyLinkedList();

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.display();
		System.out.println("Popped: " + stack.pop());

	}

}
