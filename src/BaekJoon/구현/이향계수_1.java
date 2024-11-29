package BaekJoon.구현;

import java.io.IOException;
import java.util.Scanner;

public class 이향계수_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if( b == 0 ){
            System.out.println(0);
            return;
        }
//        System.out.println(number(b));
//        System.out.println(number(a, 0, b));
        System.out.println(number(a, 0, b) / number(b) );

    }
    public static int number(int n, int depth, int end){
        if(depth==end){
            return 1;
        }
        return n * number(n - 1, depth+1, end);
    }
    public static int number(int n){
        if(n == 1){
            return 1;
        }
        return n * number(n-1);
    }
}
