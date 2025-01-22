package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BaekJoon1912 {
    static int N;
    static int[] arr;
    static int[] dp;
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dp = new int[N];

        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        max = arr[0];
        for(int i = 1 ; i < arr.length; i++){
            dp[i] = Math.max(dp[i - 1] + arr[i] , arr [i]);
            max = Math.max(max,dp[i]);
        }















    }
}
//        for(int i = 1 ; i < N ; i++) {
//            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
//            max = Math.max(max, dp[i]);
//        }
//        System.out.println(max);
