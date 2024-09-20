package BaekJoon.Inflearn.classArray;

import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resultLength = scanner.nextInt();
        while( resultLength > 0 ) {
            resultLength--;
            int count = scanner.nextInt();
            int result = 0;
            int[] arr = new int[20];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < i; j++) {
                    if(arr[j] > arr[i]) {
                        result++;
                    }
                }
            }
            System.out.println(count + " "+ result);
        }
    }
}
