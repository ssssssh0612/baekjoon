package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 리그오브레전설_17271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int next1 = i + 1;
            int next2 = i + m;
            if(next1 <= n){
                dp[next1] += dp[i]%1000000007;
            }

            if(next2 <= n){
                dp[next2] += dp[i]%1000000007;
            }
        }
        System.out.println(dp[n]%1000000007);

    }
}
