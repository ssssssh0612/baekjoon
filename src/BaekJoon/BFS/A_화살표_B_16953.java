package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A_화살표_B_16953 {
    static long[] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long start = sc.nextLong();
        long end = sc.nextLong();
        graph = new long[(int) end];


    }
    public static void bfs(long startNum){
        Queue<Long[]> queue = new LinkedList<>();

    }
}
//    static Queue<Long[]> queue = new LinkedList<Long[]>();
//    static int result;
//    static int start;
//    static int count;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        start = sc.nextInt();
//        result = sc.nextInt();
//        System.out.println(bfs(start,0));
//    }
//
//    public static long bfs(long start, long operation) {
//        queue.add(new Long[]{start,operation});
//        while (!queue.isEmpty()) {
//            Long[] now = queue.poll();
//            if(now[0] == result){
//                return now[1]+1;
//            }
//            for (int i = 0; i < 2; i++) {
//                if(i==0 && plusOne(now[0]) <= result){
//                    queue.add(new Long[]{plusOne(now[0]),now[1]+1});
//                }else if(i==1 && multiplyTwo(now[0]) <= result){
//                    queue.add(new Long[]{multiplyTwo(now[0]),now[1]+1});
//                }
//            }
//        }
//        return -1;
//    }
//
//    public static long plusOne(long number) {
//        String stringNumber = number + "1";
//        return Long.parseLong(stringNumber);
//    }
//
//    public static long multiplyTwo(long number) {
//        return  (number * 2);
//    }
//}

//import java.util.*;
//
//public class Main {
//    static Queue<Long> queue = new LinkedList<Long>();
//    static List<Long> list = new ArrayList<Long>();
//    static long[] distance;
//    static long result;
//    static long start;
//    static long count;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        start = sc.nextLong();
//        result = sc.nextLong();
//        distance = new long[100000000];
//        bfs(start);
//        if(distance[(int) result] == 0) {
//            System.out.println(-1);
//        }else{
//            System.out.println(distance[(int) result]+1);
//        }
//    }
//
//    public static void bfs(long start) {
//        queue.add(start);
//        while (!queue.isEmpty()) {
//            long now = queue.poll();
//            if(now > result){
//                break;
//            }
//            for (int i = 0; i < 2; i++) {
//                if (i == 0) {
//                    if (!(plusOne(now) > result)) {
//                        queue.add(plusOne(now));
//                        distance[(int) plusOne(now)] = distance[(int) now]+1;
//                    }
//                } else {
//                    if(!(multiplyTwo(now)>result)) {
//                        queue.add(multiplyTwo(now));
//                        distance[(int) multiplyTwo(now)] = distance[(int) now]+1;
//                    }
//                }
//            }
//        }
//    }
//
//    public static long plusOne(long number) {
//        String stringNumber = number + "1";
//        return Long.parseLong(stringNumber);
//    }
//
//    public static long multiplyTwo(long number) {
//        return number * 2;
//    }
//}
