package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp1_2_3더하기_4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase; i++){
            // 4, 7, 10
            int number = Integer.parseInt(br.readLine());
            System.out.println(result(number));
        }
    }
    public static int result( int number ){
        int[] dp = new int[number + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = ;
        return 0;
    }
}
