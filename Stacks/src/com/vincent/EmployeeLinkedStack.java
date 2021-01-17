package com.vincent;

import java.util.LinkedList;
import java.util.ListIterator;

public class EmployeeLinkedStack {

    private LinkedList<Employee> stack;

    public EmployeeLinkedStack() {
        stack = new LinkedList<Employee>();
    }

    // worse case: 0(n) constant time
    public void push(Employee employee) {
        stack.push(employee);
    }

    // worse case: 0(1) constant time
    public Employee pop() {
        return stack.pop();
    }

    // worse case: 0(1) constant time
    public Employee peek() {
        return stack.peek();
    }

    // worse case: 0(1) constant time
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // worse case: 0(n) linear time
    public void printStack() {
        ListIterator<Employee> iterator = stack.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
