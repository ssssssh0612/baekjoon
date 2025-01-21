package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 최대부분증가수열_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        int[] dp = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < dp.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 1;
        for(int i = 1; i < arr.length; i++){
            int number = arr[i];
            dp[i] = 1;
            int max = 1;
            for(int j = 0; j < i ; j ++){
                if(number > arr[j]){
                    max = Math.max(dp[j] + 1, max);
                }
            }
//            System.out.println(max);
            dp[i] = max;
        }
        Arrays.sort(dp);
        System.out.println(dp[dp.length - 1]);
    }
}
