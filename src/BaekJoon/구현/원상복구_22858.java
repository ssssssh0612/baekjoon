package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 원상복구_22858 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];

        int[] arr2 = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int[] newResult = new int[n];
            for (int j = 0; j < n; j++) {
                newResult[j] = result[arr1[j] - 1];
            }
            result = newResult;
        }

        int[] result1 = new int[n];
        for (int i = 0; i < n; i++) {
            int num = arr2[i];
            result1[result[i]] = num;
        }

        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }

    }
}
