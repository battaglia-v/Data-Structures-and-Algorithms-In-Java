package com.vincent;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        // The built-in PriorityQueue in the JDK is a min heap implementation:
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

//        System.out.println(pq.peek());
//        System.out.println(pq.remove());
//        System.out.println(pq.peek());
//        System.out.println(pq.poll());
//        System.out.println(pq.peek());
        System.out.println(pq.remove(54));

        Object[] ints = pq.toArray();
        for (Object num: ints) {
            System.out.println(num);
        }

//        System.out.println(pq.peek());
//        pq.add(-1);
//        System.out.println(pq.peek());
    }
}
