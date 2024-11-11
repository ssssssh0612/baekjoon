package BaekJoon.구현;

import java.util.*;

public class Deque예제 {
    public static void main(String[] args){
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> deque1 = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        deque.addFirst(2);
        deque.addFirst(1);
        deque.addFirst(3);
        deque.addLast(5);
        System.out.println(deque.poll());
        System.out.println(deque.poll());
        System.out.println(deque.poll());
        System.out.println(deque.poll());


    }
}
