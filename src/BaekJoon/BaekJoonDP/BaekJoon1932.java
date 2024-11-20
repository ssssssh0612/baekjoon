package BaekJoon.BaekJoonDP;

import java.util.Scanner;

public class BaekJoon1932 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int dp[][] = new int[a+1][a+1];
        int dp1[][] = new int[a+1][a+1];
        for(int i=0; i<a; i++){
            for(int j=0; j<=i; j++){
                dp[i][j]= sc.nextInt();
            }
        }
        for(int i=0; i<a; i++){
            for(int j=0; j<=i; j++){
                dp1[i][j]=dp[i][j];
            }
        }
        if(a==1){
            System.out.println(Math.max(dp[1][0]=dp[0][0]+dp[1][0],dp[1][1]=dp[0][0]+dp[1][1]));
        }
        else{
            dp[1][0]=dp[0][0]+dp[1][0];
            dp[1][1]=dp[0][0]+dp[1][1];
            for(int i=2; i<a; i++){
                for(int j=0; j<=i; j++){
                    for(int r=j; r<j+2; r++){
                        dp[i][r] = Math.max(dp[i - 1][j] + dp1[i][r], dp[i][r]);
                    }
                }
            }
            int max=0;
            for(int i=0; i<a; i++){
                    if(max<dp[a-1][i]) {
                        max = dp[a-1][i];
                    }
            }
            System.out.println(max);

        }
    }
}
