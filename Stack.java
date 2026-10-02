package day_3;

public class Stack {

    private int maxSize;
    private int[] arr;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        arr = new int[maxSize];
        top = -1;
    }

    public void push(int data) {

        if (top == maxSize - 1) {
            System.out.println("Stack is full");
            return;
        }

        top++;
        arr[top] = data;

        System.out.println(data + " pushed");
    }

    public int pop() {

        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        int data = arr[top];
        top--;

        return data;
    }

    public int peek() {

        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        return arr[top];
    }
}