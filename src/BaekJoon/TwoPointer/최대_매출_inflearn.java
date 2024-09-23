package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대_매출_inflearn {
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrSize = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int[] arr = new int[arrSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrSize; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int end = length;
        int total = 0;
        for (int i = 0; i < end; i++) {
            total += arr[i];
        }
        for (int i = end; i < arrSize; i++) {

            total += arr[i] - arr[i - end];
            result = Math.max(result, total);
        }
        System.out.println(result);
    }
}
