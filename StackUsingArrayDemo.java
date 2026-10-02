package day_3;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingArrayDemo {

	public static void main(String[] args) {
		//Deque<Integer> stack=new ArrayDeque<>();
		Stack stack = new Stack(5);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		//This will not be inserted
		stack.push(60);
		
		System.out.println("Top element: "+stack.peek());
		System.out.println("Popped element: "+stack.pop());
	System.out.println("Top element after pop: "+stack.peek());
	}
	}
	