package BaekJoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Flatten_1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int dump = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[100];
            int sum = 0;
            for (int j = 0; j < 100; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            while (dump > 0) {
                Arrays.sort(arr);
                dump--;
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);
            System.out.println("#"+(i+1)+" "+(arr[99]-arr[0]));
        }
    }
}
