package com.vincent;

public class IntegerLinkedList {

    private IntegerNode head;
    private int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value) {

        // assumption: the list is sorted

        if (head == null || value < head.getValue()) {
            addToFront(value);
            return;
        }

        // find the insertion point

        IntegerNode current = head.getNext();
        IntegerNode previous = head;
        IntegerNode newNode = new IntegerNode(value);

        while (current != null && value > current.getValue()) {
            previous = current;
            current = current.getNext();
        }

        newNode.setNext(current);
        previous.setNext(newNode);

        // update size after the insertion

        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
