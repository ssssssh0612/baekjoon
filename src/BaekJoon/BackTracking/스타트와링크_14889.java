package BaekJoon.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 스타트와링크_14889 {
    static int count = 0;
    static int n;
    static int[][] graph;
    static boolean[] visited;
    static int[] arr;

    static int[] arrStart = new int[2];
    static boolean[] visitedStart;

    static int[] arrLink = new int[2];
    static boolean[] visitedLink;

    static List<Integer> list = new ArrayList<>();
    static int result = 0;
    static int result1 = 0;
    static int result2 = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n+1][n+1];
        visitedStart = new boolean[n/2];
        visitedLink = new boolean[n/2];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[n];
        arr = new int[n/2];
        backTracking(0,0);
        System.out.println(result);

    }
    // 팀을 나누기
    public static void backTracking(int depth, int index){
        if(depth == n / 2){
            boolean[] check = new boolean[n+1];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 1; j <= n; j++) {
                    if(arr[i] == j){
                        check[j] = true;
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                if(!check[i]){
                    list.add(i);
                }
            }

//            System.out.println("백트래킹 전 체크");
//            for (int i = 0; i < arr.length; i++) {
//                System.out.print(arr[i] + " ");
//            }

//            for (int i = 0; i < list.size(); i++) {
//                System.out.print(list.get(i)+" ");
//            }

            backTracking(0);
//            System.out.println("링크찍기전");
//            System.out.println(list.size());
//            for (int i = 0; i < visitedLink.length; i++) {
//                System.out.println(visitedLink[i]);
//            }
            backTracking2(0);

            if(count == 0){
                result = Math.abs(result1-result2);
            }else{
                result = Math.min(Math.abs(result1-result2),result);
            }
            count++;
            result1 = 0;
            result2 = 0;
            list.clear();
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i] && index <= i ){
                visited[i] = true;
                arr[depth] = i + 1;
                backTracking(depth + 1, i);
                visited[i] = false;
            }
        }
    }


    public static void backTracking(int depth){
        if(depth == 2){
//            System.out.println();
//            System.out.println("스타트");
//            for (int i = 0; i < arrStart.length; i++) {
//                System.out.print(arrStart[i]+" ");
//            }
//            System.out.println();
            result1 = result1 + graph[arrStart[0]][arrStart[1]];
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(!visitedStart[i]){
                visitedStart[i] = true;
                arrStart[depth] = arr[i];
                backTracking(depth + 1);
                visitedStart[i] = false;
            }
        }
    }
    public static void backTracking2(int depth){
        if(depth == 2){
//            System.out.println("링크");
//            for (int i = 0; i < arrLink.length; i++) {
//                System.out.print(arrLink[i]+" ");
//            }
            result2 = result2 + graph[arrLink[0]][arrLink[1]];
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if(!visitedLink[i]){
                visitedLink[i] = true;
                arrLink[depth] = list.get(i);
                backTracking2(depth + 1);
                visitedLink[i] = false;
            }
        }
    }

    public static int backTrackingArr(int depth){
//        if(depth == 2){
//
//        }
//        for (int i = 0; i < ; i++) {

//        }
        return 0;
    }

    public static void checkingGraph(){
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                System.out.print(graph[i][j] +" ");
            }
            System.out.println();
        }
    }

}
