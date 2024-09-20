package BaekJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaekJoon25305 {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        Collections.sort(list);
        int a = sc.nextInt();
        if(a==0){
            System.out.println(1);
        }else{
            System.out.println(factorial(a));
        }
    }
    public static long factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
