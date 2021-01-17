package com.vincent;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedList<Employee> list = new LinkedList<>();

        //Adds element to the head (beginning) of the list
        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marySmith);
        list.addFirst(mikeWilson);

        printList(list);

        // Adds element to the tail (end) of the list
        list.add(billEnd);
        printList(list);

        list.removeLast();
        printList(list);


    }

    public static void printList(LinkedList<Employee> list) {

        Iterator iterator = list.iterator();
        System.out.print("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" <=> ");
        }
        System.out.println("null");

// Alternate way to loop through list:
//        for (Employee employee: list) {
//            System.out.println(employee);
//        }
    }


}
