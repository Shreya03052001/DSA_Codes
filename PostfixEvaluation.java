package day_3;

public class PostfixEvaluation {

    public static void main(String[] args) {

        String expression = "23*54*+9-";

        Stack stack = new Stack(20);

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // If it is a number
            if (Character.isDigit(ch)) {

                int number = ch - '0';

                stack.push(number);
            }

            // If it is an operator
            else {

                int operand1 = stack.pop();
                int operand2 = stack.pop();

                int result = 0;

                if (ch == '+') {
                    result = operand2 + operand1;
                }
                else if (ch == '-') {
                    result = operand2 - operand1;
                }
                else if (ch == '*') {
                    result = operand2 * operand1;
                }
                else if (ch == '/') {
                    result = operand2 / operand1;
                }

                System.out.println(
                    operand2 + " " + ch + " " + operand1 + " = " + result
                );

                stack.push(result);
            }
        }

        System.out.println("Final Result: " + stack.pop());
    }
}