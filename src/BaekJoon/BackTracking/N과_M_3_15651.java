package BaekJoon.BackTracking;

import java.util.Scanner;

public class N과_M_3_15651 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[m];
        backTracking(n,m,0,0);
    }
    public static void backTracking(int n, int m, int depth, int number){
        if( depth == m){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if( i >= number ){
                arr[depth] = i + 1;
                backTracking(n,m,depth+1,i);
            }
        }
    }
}
