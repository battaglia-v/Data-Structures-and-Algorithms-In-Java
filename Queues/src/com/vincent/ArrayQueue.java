package com.vincent;

import java.util.NoSuchElementException;

public class ArrayQueue {

    // back field points to the next available spot
    // in the array queue

    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {

        // if true, this means that the initial backing array is full
        // and we must resize the array (double the size)

        if (back == queue.length) {
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }

        queue[back] = employee;
        back++;
    }

    public Employee remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Employee employee = queue[front];

        // cleaning up the data that is no longer used:

        queue[front] = null;
        front++;

        // if all items have been removed from the queue,
        // we can reset the front and back values (to be more optimized):

        if (size() == 0) {
            front = 0;
            back = 0;
        }

        return employee;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public void printQueue() {
        for (int i=front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }


}
