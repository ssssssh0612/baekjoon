package BaekJoon.BaekJoon재귀;

import java.util.Scanner;

public class BookJoon10875 {
    public int factorial(int a){
        if(a==1){
            return 0;
        }
        return a*factorial(a-1);
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

    }
}
