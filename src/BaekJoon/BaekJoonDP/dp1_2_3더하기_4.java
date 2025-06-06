package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class dp1_2_3더하기_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1_000_001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        for(int i = n; i >= 0; i--){
            if( i % 3 == 0 ) {
                int num = dp[i] + 1;
                int movingNum = i / 3;
                if(dp[movingNum] > num){
                    dp[movingNum] = num;
                }
            }

            if( i % 2 == 0 ){
                int num = dp[i] + 1;
                int movingNum = i / 2;
                if(dp[movingNum] > num){
                    dp[movingNum] = num;
                }
            }

            int num = dp[i] + 1;
            int movingNum = i - 1;
            if(movingNum >= 0 && dp[movingNum] > num){
                dp[movingNum] = num;
            }
        }
        System.out.println(dp[1]);
    }
}
