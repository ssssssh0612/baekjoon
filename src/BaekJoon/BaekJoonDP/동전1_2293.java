package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전1_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        int[] arr = new int[count + 1];
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i <= count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = arr[i]; j <= length; j++){
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(dp[length]);

    }
}
