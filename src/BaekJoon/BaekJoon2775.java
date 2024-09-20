package BaekJoon;

import java.util.Scanner;

public class BaekJoon2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[][] dp = new int[15][15];

        for (int i = 1; i <= 14; i++) {
            dp[0][i] = i;
            dp[i][1] = 1;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 2; j <= 14; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        for (int i = 0; i < a; i++) {
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.println(dp[b][c]);
        }
    }
}
