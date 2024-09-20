package BaekJoon.DataStructure.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 격자판최대합_inflearn {
    static int result = 0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max = max + arr[i][j];
            }
            result = Math.max(max, result);
        }

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max = max + arr[j][i];
            }
            result = Math.max(max, result);
        }
        int cross1 = 0;
        for (int i = 0; i < n; i++) {
            cross1 = cross1 + arr[i][i];
        }

        int cross2 = 0;
        int indexNum = n - 1;
        for (int i = 0; i < n; i++) {
            cross2 = cross2 + arr[i][indexNum];
            indexNum--;
        }

        result = Math.max(result, cross1);
        System.out.println(result);

    }
}
