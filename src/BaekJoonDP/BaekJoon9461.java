package BaekJoonDP;

import java.util.Scanner;

public class BaekJoon9461 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        for(int i=0; i<a; i++){
            int b = sc.nextInt();
            long dp[] = new long[b+1];

            if(b==0){
                dp[0]=1;
            }
            if(b==1){
                dp[0]=1;
                dp[1]=1;
            }
            if(b==2){
                dp[0]=1;
                dp[1]=1;
                dp[2]=1;
            }
            if(b==3){
                dp[0]=1;
                dp[1]=1;
                dp[2]=1;
                dp[3]=2;
            }
            if(b==4){
                dp[0]=1;
                dp[1]=1;
                dp[2]=1;
                dp[3]=2;
                dp[4]=2;
            }
            if(b==5){
                dp[0]=1;
                dp[1]=1;
                dp[2]=1;
                dp[3]=2;
                dp[4]=2;
                dp[5]=3;
            }
            for(int j=5; j<b; j++){
                dp[0]=1;
                dp[1]=1;
                dp[2]=1;
                dp[3]=2;
                dp[4]=2;
                dp[5]=3;
                dp[j]=dp[j-5]+dp[j-1];
            }
            System.out.println(dp[b-1]);
        }
    }
}
