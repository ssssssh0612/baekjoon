package BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon2217 {
    public static void main(String[] args) {
        ArrayList<Integer> integers1 = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int sum=0;
        int result=0;
        int arr[]= new int[a];
        for(int i=0; i<a; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i=0; i<a; i++){
                sum = arr[i] * (arr.length - i);
                if (sum > result) {
                    result = sum;
                    sum = 0;
                } else {
                    sum = 0;
                }

        }

        System.out.println(result);
    }
}
