package BaekJoon;

import java.util.Scanner;

public class BaekJoon2475 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int sum=0;
        for(int i=0; i<5; i++){
            int a = sc.nextInt();
            sum=sum+a*a;
        }
        System.out.println(sum%10);
    }
}
