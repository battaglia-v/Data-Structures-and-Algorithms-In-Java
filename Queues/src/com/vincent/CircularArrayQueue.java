package com.vincent;

import java.util.NoSuchElementException;

public class CircularArrayQueue {

    // back field points to the next available spot
    // in the array queue

    private Employee[] queue;
    private int front;
    private int back;

    public CircularArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        // if true, this means that the initial backing array is full.
        // We first need to unwrap the queue, and then resize the array

        if ( size() == queue.length - 1) {
            int numItems = size();
            Employee[] newArray = new Employee[2 * queue.length];

            // copy the elements from the front, to the end of the current queue
            // (before it becomes circular)

            System.arraycopy(queue, front, newArray, 0, queue.length - front);

            // copy the remaining elements (after it loops back circularly) up to the back,
            // since the back points to next available position, and equals the amount of
            // items wrapped to the front.

            System.arraycopy(queue, 0, newArray, queue.length - front, back);
            queue = newArray;

            front = 0;
            back = numItems;
        }

        queue[back] = employee;
        if (back < queue.length - 1) {
            back++;
        }
        else {
            back = 0;
        }
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
        // if we are at the end of the queue, we will then wrap the front
        // pointer to the beginning of the queue, in which it will become
        //  a circular array queue:

        else if (front == queue.length) {
            front = 0;
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
        if (front <= back) {
            return back - front;
        }
        else {

            // if the queue is circular, then we calculate
            // the size of the circular array queue like so:

            return back - front + queue.length;
        }
    }

    public void printQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {

            // if the queue is circular, we first print
            // from the front pointer to the end of the queue, and then
            // circle back to printing the beginning to the
            // back pointer

            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
    }
}
