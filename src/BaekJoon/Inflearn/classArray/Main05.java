package BaekJoon.Inflearn.classArray;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [][] arr = new int[101][101];
        int result = 0;
        int count = scanner.nextInt();
        int resultCount = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            for (int j = a; j <= c; j++) {
                for (int k = b; k <= d; k++) {
                    arr[j][k]++;
                }
            }
        }
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (arr[i][j] > resultCount) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
