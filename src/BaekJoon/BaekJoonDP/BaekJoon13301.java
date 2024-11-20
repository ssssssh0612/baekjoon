package BaekJoon.BaekJoonDP;

import java.util.Scanner;

public class BaekJoon13301 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        long dp[] = new long[a+1];
        if(a==1){
            System.out.println(4);
        }
        else if(a==2){
            System.out.println(6);
        }
        else if(a==3){
            System.out.println(10);
        }
        else if(a==4){
            System.out.println(16);
        }
        else{
            dp[0]=1;
            dp[1]=1;
            for(int i=2; i<a; i++){
                dp[i]= dp[i-1]+dp[i-2];
            }
            System.out.println(dp[a-1]*4+dp[a-2]+dp[a-3]+dp[a-4]);
        }
    }
}
