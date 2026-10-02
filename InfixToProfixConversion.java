package day_3;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToProfixConversion {

	public static void main(String[] args) {

		// Infix expression
		// Infix means operator is written between operands
		// Example: A + B
		String infixExpression = "(A+B)*C";

		// Display the original infix expression
		System.out.println("Infix Expression: " + infixExpression);

		// Call the conversion method and display the postfix expression
		System.out.println("Postfix Expression: "
				+ infixToPostFix(infixExpression));
	}

	// Method to convert infix expression into postfix expression
	private static String infixToPostFix(String infixExpression) {

		// StringBuilder is used to store the final postfix expression
		StringBuilder postfix = new StringBuilder();

		// Deque is used as a Stack
		// It stores operators such as +, -, *, /, ^
		Deque<Character> stack = new ArrayDeque<>();

		// Convert the String into a character array
		// Example: "A+B*C" -> A, +, B, *, C
		char[] input = infixExpression.toCharArray();

		// Scan each character one by one
		for (char c : input) {

			// Check whether the character is an operand
			// Operand can be a letter or a number
			// Example: A, B, C, 1, 2, 3
			if (Character.isLetterOrDigit(c)) {

				// Directly add operand to postfix expression
				postfix.append(c);

			// Check whether the character is an opening bracket
			} else if (c == '(') {

				// Push opening bracket into the stack
				stack.push(c);

			// Check whether the character is a closing bracket
			} else if (c == ')') {

				// Remove operators from stack until '(' is found
				while (!stack.isEmpty() && stack.peek() != '(') {

					// Remove operator from stack
					// and add it to postfix
					postfix.append(stack.pop());
				}

				// Remove '(' from the stack
				if (!stack.isEmpty()) {
					stack.pop();
				}

			// If the character is not an operand or bracket,
			// then it is an operator
			} else {

				// Compare the precedence of the current operator
				// with the operator already present on the stack
				while (!stack.isEmpty()
						&& stack.peek() != '('
						&& getPrecedence(stack.peek()) >= getPrecedence(c)) {

					// Higher/equal precedence operator is removed
					// from stack and added to postfix
					postfix.append(stack.pop());
				}

				// Push the current operator into the stack
				stack.push(c);
			}
		}

		// After scanning the complete expression,
		// some operators may still be present in the stack
		while (!stack.isEmpty()) {

			// Remove remaining operators and add them to postfix
			postfix.append(stack.pop());
		}

		// Convert StringBuilder into String and return it
		return postfix.toString();
	}

	// Method to determine operator precedence
	private static int getPrecedence(char c) {

		// Higher number means higher precedence
		return switch (c) {

		// Power has highest precedence
		case '^' -> 3;

		// Multiplication and division have second priority
		case '*', '/' -> 2;

		// Addition and subtraction have lowest priority
		case '+', '-' -> 1;

		// If character is not a valid operator
		default -> throw new IllegalArgumentException(
				"Invalid Operator: " + c);
		};
	}
}