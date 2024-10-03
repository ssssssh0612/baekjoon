package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 테트리스_게임_4920 {
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine().trim());
//            int n = sc.nextInt();
            if (n == 0) break;
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nemo(i, j, arr);
                    I(i, j, arr);
                    S(i, j, arr);
                    fuck(i, j, arr);
                    ni(i, j, arr);
                }
            }
            System.out.println(count + ". " + result);
            result = Integer.MIN_VALUE;
            count++;
        }
    }

    public static void S(int y, int x, int[][] arr) {
        int result1 = 0;
        boolean check = false;
        if (checking(y, x, arr) && checking(y, x + 1, arr) && checking(y + 1, x + 1, arr) && checking(y + 1, x + 2, arr)) {
            check = true;
            result1 += arr[y][x];
            result1 += arr[y][x + 1];
            result1 += arr[y + 1][x + 1];
            result1 += arr[y + 1][x + 2];
        }
        if (check) {
            result = Math.max(result, result1);
        }

        int result2 = 0;
        boolean check2 = false;
        if (checking(y, x, arr) && checking(y + 1, x, arr) && checking(y + 1, x - 1, arr) && checking(y + 2, x - 1, arr)) {
            check2 = true;
            result2 += arr[y][x];
            result2 += arr[y + 1][x];
            result2 += arr[y + 1][x - 1];
            result2 += arr[y + 2][x - 1];
        }
        if (check2) {
            result = Math.max(result, result2);
        }
    }

    public static void nemo(int y, int x, int[][] arr) {
        int result1 = 0;
        boolean check = false;
        if (checking(y, x, arr) && checking(y, x + 1, arr) && checking(y + 1, x, arr) && checking(y + 1, x + 1, arr)) {
            check = true;
            result1 += arr[y][x];
            result1 += arr[y][x + 1];
            result1 += arr[y + 1][x];
            result1 += arr[y + 1][x + 1];
        }
        if (check) {
            result = Math.max(result, result1);
        }
    }

    public static void I(int y, int x, int[][] arr) {
        int result1 = 0;
        boolean check = false;
        if (checking(y, x, arr) && checking(y, x + 1, arr) && checking(y, x + 2, arr) && checking(y, x + 3, arr)) {
            check = true;
            result1 += arr[y][x];
            result1 += arr[y][x + 1];
            result1 += arr[y][x + 2];
            result1 += arr[y][x + 3];
        }
        if (check) {
            result = Math.max(result, result1);
        }
        int result2 = 0;
        boolean check2 = false;
        if (checking(y, x, arr) && checking(y + 1, x, arr) && checking(y + 2, x, arr) && checking(y + 3, x, arr)) {
            check2 = true;
            result2 += arr[y][x];
            result2 += arr[y + 1][x];
            result2 += arr[y + 2][x];
            result2 += arr[y + 3][x];
        }
        if (check2) {
            result = Math.max(result, result2);
        }
    }

    public static void fuck(int y, int x, int[][] arr) {
        int result1 = 0;
        boolean check1 = false;
        if (checking(y, x, arr) && checking(y - 1, x, arr) && checking(y, x + 1, arr) && checking(y, x - 1, arr)) {
            check1 = true;
            result1 += arr[y][x];
            result1 += arr[y - 1][x];
            result1 += arr[y][x + 1];
            result1 += arr[y][x - 1];
        }
        if (check1) {
            result = Math.max(result, result1);
        }
        int result2 = 0;
        boolean check2 = false;
        if (checking(y, x, arr) && checking(y, x + 1, arr) && checking(y - 1, x, arr) && checking(y + 1, x, arr)) {
            check2 = true;
            result2 += arr[y][x];
            result2 += arr[y][x + 1];
            result2 += arr[y - 1][x];
            result2 += arr[y + 1][x];
        }
        if (check2) {
            result = Math.max(result, result2);
        }
        int result3 = 0;
        boolean check3 = false;
        if (checking(y, x, arr) && checking(y, x - 1, arr) && checking(y, x + 1, arr) && checking(y + 1, x, arr)) {
            check3 = true;
            result3 += arr[y][x];
            result3 += arr[y][x - 1];
            result3 += arr[y][x + 1];
            result3 += arr[y + 1][x];
        }
        if (check3) {
            result = Math.max(result, result3);
        }
        int result4 = 0;
        boolean check4 = false;
        if (checking(y, x, arr) && checking(y - 1, x, arr) && checking(y + 1, x, arr) && checking(y, x - 1, arr)) {
            check4 = true;
            result4 += arr[y][x];
            result4 += arr[y - 1][x];
            result4 += arr[y + 1][x];
            result4 += arr[y][x - 1];
        }
        if (check4) {
            result = Math.max(result, result4);
        }
    }

    public static void ni(int y, int x, int[][] arr) {
        int result1 = 0;
        boolean check1 = false;
        if (checking(y, x, arr) && checking(y + 1, x, arr) && checking(y, x - 1, arr) && checking(y, x - 2, arr)) {
            check1 = true;
            result1 += arr[y][x];
            result1 += arr[y + 1][x];
            result1 += arr[y][x - 1];
            result1 += arr[y][x - 2];
        }
        if (check1) {
            result = Math.max(result, result1);
        }
        int result2 = 0;
        boolean check2 = false;
        if (checking(y, x, arr) && checking(y - 1, x, arr) && checking(y - 2, x, arr) && checking(y, x - 1, arr)) {
            check2 = true;
            result2 += arr[y][x];
            result2 += arr[y - 1][x];
            result2 += arr[y - 2][x];
            result2 += arr[y][x - 1];
        }
        if (check2) {
            result = Math.max(result, result2);
        }
        int result3 = 0;
        boolean check3 = false;
        if (checking(y, x, arr) && checking(y - 1, x, arr) && checking(y, x + 1, arr) && checking(y, x + 2, arr)) {
            check3 = true;
            result3 += arr[y][x];
            result3 += arr[y - 1][x];
            result3 += arr[y][x + 1];
            result3 += arr[y][x + 2];
        }
        if (check3) {
            result = Math.max(result, result3);
        }
        int result4 = 0;
        boolean check4 = false;
        if (checking(y, x, arr) && checking(y, x + 1, arr) && checking(y + 1, x, arr) && checking(y + 2, x, arr)) {
            check4 = true;
            result4 += arr[y][x];
            result4 += arr[y][x + 1];
            result4 += arr[y + 1][x];
            result4 += arr[y + 2][x];
        }
        if (check4) {
            result = Math.max(result, result4);
        }
    }

    public static boolean checking(int y, int x, int[][] arr) {
        return y >= 0 && y < arr.length && x >= 0 && x < arr[0].length;
    }
}
