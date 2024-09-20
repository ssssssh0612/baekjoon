package BaekJoon.구현;

import java.util.Scanner;

public class 과제안내신분_5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[31];
        for (int i = 0; i < 28; i++) {
            arr[sc.nextInt()] = 1;
        }
        for (int i = 1; i <= 30; i++) {
            if(arr[i] == 0){
                System.out.println(i);
            }
        }
    }
}
