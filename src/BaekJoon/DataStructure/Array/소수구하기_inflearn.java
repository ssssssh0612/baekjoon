package BaekJoon.DataStructure.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수구하기_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[a+1];
        int result = 0;
        for (int i = 2; i <= a; i++) {
            if(arr[i] == 0){
                result++;
                checking(arr,i);
            }
        }
        System.out.println(result);
    }
    public static void checking(int[] arr, int number) {
        for (int i = number; i <= arr.length; i = i + number ) {
            if(checking2(arr,i)){
                arr[i]++;
            }
        }
    }
    public static boolean checking2(int[] arr, int number) {
        return number >= 0 && arr.length > number;
    }
}
