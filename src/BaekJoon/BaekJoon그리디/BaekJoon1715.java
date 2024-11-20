package BaekJoon.BaekJoon그리디;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1715 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int arr[] = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

    }
}
