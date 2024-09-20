package BaekJoon.DataStructure.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[b + 1];
        for (int i = 2; i <= b; i++) {
            if (arr[i] == 0) {
                if (i >= a) {
                    checking(arr,i);
                    System.out.println(i);
                }else{
                    checking(arr,i);
                }
            }
        }
    }

    public static void checking(int[] arr, int number) {
        for (int i = number; i <= arr.length; i = i + number) {
            if (checkingLength(arr, i)) {
                arr[i]++;
            }
        }
    }

    public static boolean checkingLength(int[] arr, int number) {
        return number >= 0 && number < arr.length;
    }
}
