package BaekJoon.BackTracking;

import java.util.Scanner;

public class N과_M_2_15650 {
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        //1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        //고른 수열은 오름차순이어야 한다.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[m];
        visited = new boolean[n];
        backTracking(n,m,0,0);
    }
    public static void backTracking( int n, int m, int depth, int number ){
        if( m == depth){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            // 고르지 않았다면 ..
            if(!visited[i] && i >= number){
                visited[i] = true;
                arr[depth] = i + 1;
                backTracking(n,m,depth+1,i);
                visited[i] = false;
            }
        }
    }
}
