package BaekJoon.BackTracking;

import java.util.Scanner;

public class N과_M_1 {
    public static boolean[] visited;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        visited = new boolean[n];
        arr = new int[m];
        backTracking(n,m,0);
    }
    public static void backTracking(int n, int m, int depth){
        if ( depth == m ){
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i + 1;
                backTracking(n,m,depth+1);
                visited[i] = false;
            }
        }
    }
}
