package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 오르막수_11057 {
    static final int MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[10];
        Arrays.fill(arr, 1);
        long[] dp = new long[n + 1];
        dp[1] = 10;
        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i - 1] + step(arr)) % MOD;
        }
        System.out.println(dp[n] % 10007);
    }
    public static long step(long[] arr){
        long returnNum = 0;
        // arr복사
        long[] copyArr = new long[arr.length];
        for(int i = 1; i < 10; i++ ){
            copyArr[i] = arr[i];
        }
        for(int i = 1; i < 10; i++){
            if(i == 1){
                long sum = 0;
                for(int j =1; j < 10; j++){
                    sum = (sum + arr[j]) % MOD;
                }
                arr[i] = sum;
                returnNum = sum;
            }else{
                long nowNum = copyArr[i - 1];
                arr[i] = (arr[i - 1] - nowNum + MOD) % MOD;
                returnNum = (returnNum + arr[i]) % MOD;
            }
        }
//        System.out.println(returnNum);
        return returnNum;
    }
}
