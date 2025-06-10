package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 쉬운계단수_10844 {
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[10];

        for(int i = 0 ; i <= 9 ; i ++){
            if(i != 0){
                dp[i] = 1;
            }
        }

        for(int i = 1; i < n; i++){
            dp = step(dp);

//            for(int j = 1; j < 10; j++){
//                System.out.print(dp[j] + " ");
//            }
//            System.out.println();
        }

        long sum = 0;
        for(int i = 0 ; i < 10; i++){
            sum += dp[i];
        }

        System.out.println(sum % MOD);

    }
    public static long[] step(long[] dp){
        long[] arr = new long[10];
        for(int i = 0 ; i < 10; i++){
            if(checking(i - 1)){
                arr[i - 1] += dp[i] % MOD;
            }
            if(checking(i + 1)){
                arr[i + 1] += dp[i] % MOD;
            }
        }
        return arr;
    }

    public static boolean checking(int num){
        return num >= 0 && num < 10;
    }
}
