package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 제곱수의합_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 1; j <= n ; j++){
                int num = j * j;
                if(i + num <= n){
                    dp[i + num] = Math.min(dp[i] + 1, dp[i + num]);
                }else{
                    break;
                }
            }

//            for(int j = 0; j <= n ; j++){
//                System.out.print(dp[j] +" ");
//            }
//            System.out.println();
        }
        System.out.println(dp[n]);
    }
}
