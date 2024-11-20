package BaekJoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum_1209 {
    static int result = Integer.MIN_VALUE; ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int number = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            for (int j = 0; j < 100; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            check(arr);
            check1(arr);
            check2(arr);
            check3(arr);
            System.out.println("#" + number + " " + result);
            result = Integer.MIN_VALUE;
        }
    }
    public static void check2(int[][] arr){
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += arr[i][i];
        }
        if(sum > result){
            result = sum;
        }
    }
    public static void check3(int[][] arr){
        int sum = 0;
        int index = 99;
        for (int i = 0; i < 100; i++) {
            sum += arr[i][index];
            index--;
        }
        if (sum > result) {
            result = sum;
        }
    }
    public static void check(int[][] arr) {
        for (int i = 0; i < 100; i++) {
            int sum = 0;
            for (int j = 0; j < 100; j++) {
                sum += arr[i][j];
            }
            if (sum > result) {
                result = sum;
            }
        }
    }
    public static void check1(int[][] arr) {
        for (int i = 0; i < 100; i++) {
            int sum = 0;
            for (int j = 0; j < 100; j++) {
                sum += arr[j][i];
            }
            if (sum > result) {
                result = sum;
            }
        }
    }
}
