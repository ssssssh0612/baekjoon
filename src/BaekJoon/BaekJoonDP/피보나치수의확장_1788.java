package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수의확장_1788 {
    static int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int absNum = Math.abs(num);
        long[] dp = new long[absNum + 1];
        if(num == 0){
            System.out.println(0);
            System.out.println(0);
            return;
        }
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= absNum; i++) {
            dp[i] = (dp[i - 2] % MOD + dp[i - 1] % MOD) % MOD;
        }
        if(num < 0 && absNum % 2 == 0){
            System.out.println(-1);
            System.out.println(dp[absNum]);
        }else{
            System.out.println(1);
            System.out.println(dp[absNum]);
        }
    }
}
