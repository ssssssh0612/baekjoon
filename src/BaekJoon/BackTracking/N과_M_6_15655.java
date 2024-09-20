package BaekJoon.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class N과_M_6_15655 {
    static int[] arr;
    static boolean[] visited;
    static int n ;
    static int m ;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n  = sc.nextInt();
        m  = sc.nextInt();
        visited = new boolean[n];
        arr = new int[m];
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        backTracking(0,0);
    }
    //N개의 자연수 중에서 M개를 고른 수열
    //고른 수열은 오름차순이어야 한다.
    public static void backTracking( int depth, int number){
        if ( depth == m ){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if( !visited[i] && list.get(number) <= list.get(i) ){
                arr[depth] = list.get(i);
                visited[i] = true;
                backTracking(depth + 1, i );
                visited[i] = false;
            }
        }

    }

}
