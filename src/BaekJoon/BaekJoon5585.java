package BaekJoon;

import java.util.Scanner;

public class BaekJoon5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int count =0;
        int money= 1000-a;
        int arr[] = {500,100,50,10,5,1};

        while(money>0){
            for(int i=0; i<arr.length; i++){
                if(money-arr[i]>=0){
                    money= money-arr[i];
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
