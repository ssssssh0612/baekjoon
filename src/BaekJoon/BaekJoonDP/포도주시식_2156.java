package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1]; // arr[1] ~ arr[N]
        int[] dp = new int[N + 1];  // dp[i]: i번째 포도주까지 고려한 최대 마신 양

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        if (N >= 1) dp[1] = arr[1];
        if (N >= 2) dp[2] = arr[1] + arr[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 2] + arr[i],
                            dp[i - 3] + arr[i - 1] + arr[i]));
        }

        System.out.println(dp[N]);
    }
}
