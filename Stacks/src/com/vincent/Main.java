package com.vincent;

import java.util.LinkedList;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

//        ArrayStack stack = new ArrayStack(10);
//
//        stack.push(new Employee("Jane", "Jones", 123));
//        stack.push(new Employee("John", "Doe", 4567));
//        stack.push(new Employee("Mary", "Smith", 22));
//        stack.push(new Employee("Mike", "Wilson", 3245));
//        stack.push(new Employee("Bill", "End", 78));
//
////      stack.printStack();
//
//        System.out.println(stack.peek());
//
//        System.out.println("Popped" + stack.pop());
//        System.out.println(stack.peek());
//
//        LinkedStack stack = new LinkedStack();
//
//        stack.push(new Employee("Jane", "Jones", 123));
//        stack.push(new Employee("John", "Doe", 4567));
//        stack.push(new Employee("Mary", "Smith", 22));
//        stack.push(new Employee("Mike", "Wilson", 3245));
//        stack.push(new Employee("Bill", "End", 78));
//
////        System.out.println(stack.peek());
////        stack.printStack();
//
//        System.out.println("Popped" + stack.pop());
//        System.out.println(stack.peek());



        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {
        LinkedList<Character> stack = new LinkedList<>();
        String filteredString = string.toLowerCase().replaceAll("[^a-z0-9]", "");

        for (int i = 0; i < filteredString.length(); i++) {
            char currentChar = filteredString.charAt(i);
            stack.push(currentChar);
        }

        for (int i = 0; i < stack.size(); i++) {
            if (stack.pop().equals(filteredString.charAt(i))) {
                continue;
            } else
                return false;
        }
        return true;
    }

// Alternate approach:

//        LinkedList<Character> secondStack = new LinkedList<>();
//        StringBuilder stringNoPunctuation = new StringBuilder(string.length());
//        String lowerCase = string.toLowerCase();
//
//        for (int i=0; i < lowerCase.length(); i++) {
//            char x = lowerCase.charAt(i);
//            if (x >= 'a' && x <= 'z') {
//                stringNoPunctuation.append(x);
//                secondStack.push(x);
//            }
//        }
//
//        StringBuilder reversedString = new StringBuilder(secondStack.size());
//        while (!secondStack.isEmpty()) {
//            reversedString.append(secondStack.pop());
//        }
//
//        return reversedString.toString().equals(stringNoPunctuation.toString());
//    }
}
