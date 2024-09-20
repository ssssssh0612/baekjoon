package BaekJoonDP;

import java.util.Scanner;

public class BaekJoon9095 {
    public static int result(int a){
        int dp[] = new int[a+1];
        dp[1]=1;
        if(a>=2) dp[2]=2;
        if(a>=3) dp[3]=4;
        // a[2]=3 a[3]=4 이렇게하면 제출할시 값이 오류남
        // 이렇게 정의한 이유는 int a 에 값이 0이 들어갔을때를 생각해보자
        for(int j=4; j<=a; j++ ){
            dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
        }
        return dp[a];
    }
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int k= sc.nextInt();
            System.out.println(result(k));
        }
    }
}
