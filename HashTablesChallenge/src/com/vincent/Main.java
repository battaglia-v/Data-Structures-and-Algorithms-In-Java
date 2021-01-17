package com.vincent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        Map<Integer, Employee> hashMap = new HashMap<>();

        for (int i = 0; i < employees.size(); i++) {
            if ( hashMap.putIfAbsent(employees.get(i).getId(), employees.get(i)) == null ) {
                System.out.println(employees.remove(i));
            };
        }

        System.out.println("-----------------------");

//

//        HashMap<Integer, Employee> employeeTable = new HashMap<>();
//        ListIterator<Employee> iterator = employees.listIterator();
//        List<Employee> remove = new ArrayList<>();
//
//        while (iterator.hasNext()) {
//            Employee employee = iterator.next();
//            if (employeeTable.containsKey(employee.getId())) {
//                remove.add(employee);
//            } else {
//                employeeTable.put(employee.getId(), employee);
//            }
//        }
//
//        for (Employee employee: remove) {
//            employees.remove(employee);
//        }


        employees.forEach(e -> System.out.println(e));


//        int[] nums = new int[10];
//        int[] numsToAdd = { 59382, 43, 6894, 500, 99, -58 };
//        for (int i = 0; i < numsToAdd.length; i++) {
//            nums[hash(numsToAdd[i])] = numsToAdd[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
    }

    public static int hash(int value) {
        return Math.abs(value) % 10;
    }
}
