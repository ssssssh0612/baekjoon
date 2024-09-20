package BaekJoonDP;

import java.util.Scanner;

public class BaekJoon1149 {
//    int rec(int arr[][]){
//        int red = arr[0][0];
//        int green = arr[0][1];
//        int blue = arr[0][2];
//        for(int i=0; i< arr.length; i++){
//
//        }
//        return 0;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int dp[][] = new int[a][3];
        for(int i=0; i<a; i++){
            for(int j=0; j<3; j++){
                dp[i][j] = sc.nextInt();
            }
        }
        for(int i=1; i<a; i++){
            for(int j=0; j<3; j++){
                if(j==0){ // ㅃㅏㄹ강
                    dp[i][0]=Math.min(dp[i-1][j+1]+dp[i][j],dp[i-1][j+2]+dp[i][j]);
                }else if(j==1){ // 초록
                    dp[i][1]=Math.min(dp[i-1][j-1]+dp[i][j],dp[i-1][j+1]+dp[i][j]);
                }else if(j==2){ // 파랑
                    dp[i][2]=Math.min(dp[i-1][j-1]+dp[i][j],dp[i-1][j-2]+dp[i][j]);
                }
            }
        }
        System.out.println(Math.min(dp[a-1][0],Math.min(dp[a-1][1],dp[a-1][2])));
    }
}
