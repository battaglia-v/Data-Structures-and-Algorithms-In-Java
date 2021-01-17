package com.vincent;

import java.util.EmptyStackException;

public class EmployeeArrayStack {

    private Employee[] stack;
    private int top;

    public EmployeeArrayStack(int capacity) {
        stack = new Employee[capacity];
    }

    // worse case: 0(n) - when having to resize the array
    public void push(Employee employee) {
        if (top == stack.length) {
            // need to resize the backing array
            Employee[] newArray = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }

        stack[top++] = employee;
    }

    // worse case: 0(1) - as we are not worrying about resizing the array
    public Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // top is a placeholder for the next available slot in the stack,
        // thus (top - 1) contains the top element currently on the stack
        Employee employee = stack[--top];
        stack[top] = null;
        return employee;
    }

    // worse case: always 0(1)
    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

}
