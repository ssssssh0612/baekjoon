package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수익_4097 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int[] arr = new int[n];
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                dp[i] = arr[i];
            }

            Arrays.fill(dp, Integer.MIN_VALUE);
            dp[0] = arr[0];
            int max = dp[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
                max = Math.max(dp[i], max);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);


    }
}
