package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장큰증가하는부분수열_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        int[] dp = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        // 증가하는 부분수열의 최대합
        for(int i = 1; i < length; i++){
            int number = arr[i];
            int max = arr[i];
            for(int j = 0 ; j < i; j++){
                // 각 숫자의 최대값
                if(number > arr[j]){
                    max = Math.max(dp[j] + number, max);
                }
            }
            dp[i] = max;
        }

        Arrays.sort(dp);
        System.out.println(dp[dp.length - 1]);



    }
}
