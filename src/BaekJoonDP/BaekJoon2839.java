package BaekJoonDP;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon2839 {
    public static void main(String[] args){
                Scanner scanner = new Scanner(System.in);
                int n = scanner.nextInt();

                int[] dp = new int[n + 1];
                Arrays.fill(dp, 10001);

                dp[0] = 0;
                for (int i = 3; i <= n; i++) {
                    dp[i] = Math.min(dp[i], dp[i - 3] + 1);
                }
                for (int i = 5; i <= n; i++) {
                    dp[i] = Math.min(dp[i], dp[i - 5] + 1);
                }


                System.out.println(dp[n] == 10001 ? -1 : dp[n]);
            }
        }
