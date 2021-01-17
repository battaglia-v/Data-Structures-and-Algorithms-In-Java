package academy.learnprogramming.queueschallenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import sun.awt.image.ImageWatched;

public class Main {

    public static void main(String[] args) {
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
        LinkedList<Character> queue = new LinkedList<>();

        String filteredString = string.toLowerCase().replaceAll("[^a-z0-9]", "");

        for (int i = 0; i < filteredString.length(); i++) {
            char currentChar = filteredString.charAt(i);
            stack.push(currentChar);
            queue.addLast(currentChar);
        }

        for (int i = 0; i < stack.size(); i++) {
            if (stack.pop().equals(queue.removeFirst())) {
                continue;
            } else
                return false;
        }
        return true;
    }
}
