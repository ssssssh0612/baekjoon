package BaekJoon.BaekJoonDP;

import java.util.Scanner;

public class BaekJoon11053 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int arr[]= new int[a+1];
        int dp[]= new int[a+1];
        int count=0;
        int sum=0;
        for(int i =0; i<a; i++){
            arr[i]= sc.nextInt();
        }
        for(int i=0; i<a; i++){
            dp[i] = arr[i];
            for(int j=i; j<a; j++){
               if(dp[i]<arr[j]) {
                   dp[i] = arr[j];
                   count++;
               }
            }
            if(count>sum){
                sum=count;
                count=0;
            }
            else{
                count=0;
            }
        }
        System.out.println(sum+1);
    }
}
