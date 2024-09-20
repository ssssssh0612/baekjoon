package BaekJoon;

import java.util.Scanner;

public class BaekJoon12847 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long sum=0;
        long result=0;
        int arr[]= new int[a];
        for (int i = 0; i < a; i++) {
            arr[i]=sc.nextInt();
        }
        for (int i = 0; i < a-b; i++) {
            for(int j=i; j<i+b; j++) {
                sum +=arr[j];
            }
            if(result<sum){
                result=sum;
                sum=0;
            }
            else{
                sum=0;
            }
        }
        System.out.println(result);
}}
