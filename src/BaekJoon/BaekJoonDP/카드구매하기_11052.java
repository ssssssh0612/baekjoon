package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카드구매하기_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            // 입력 받기
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                int num = arr[j];
                if(i + (j + 1) > n) break;
                dp[i + (j + 1)] = Math.max(dp[i + (j + 1)], dp[i] + num);
            }

        }
        System.out.println(dp[n]);

    }
}
