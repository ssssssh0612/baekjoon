package BaekJoonDP;

import java.util.Scanner;

public class BaekJoon11726 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int dp[] = new int[a+1];
        dp[0]=1;
        dp[1]=2;
        for(int i=2; i<=a; i++){
            dp[i]= dp[i-1]+dp[i-2];
        }
        System.out.println(dp[a-1]%10007);
    }
}
