package org.example.Exercise;

public class Stack {
    private static final int MAX_SIZE = Integer.MAX_VALUE;
    private static final int[] stacks = new int[MAX_SIZE];
    static int top = -1;

    boolean isFull() {
        return top == MAX_SIZE;
    }

    void push(int data) {
        if (!isFull()) {
            top = top + 1;
            stacks[top] = data;
        } else {
            System.out.println("error!, stack full");
        }
    }

    boolean isEmpty() {
        return top != -1;
    }

    int pop() {
        int data = 0;
        if (isEmpty()) {
            top = top - 1;
            stacks[top] = data;
            return data;
        } else {
            System.out.println("empty stack!");
        }
        return data;
    }

    void main() {
        push(3); // un-Usable value, pushed to the stack.
        push(8);
        push(9);
        push(4);
        while (isEmpty()) {
            int data = pop();
            System.out.println(data + " ");

        }

    }

}
