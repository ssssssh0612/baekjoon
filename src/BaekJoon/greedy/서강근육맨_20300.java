package BaekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서강근육맨_20300 {
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        if (num % 2 == 0) {
            int index = num - 1;
            result = Long.MIN_VALUE;
            for (int i = 0; i < num / 2; i++) {
                result = Math.max(arr[i] + arr[index], result);
                index--;
            }
        } else {
            int index = num - 2;
            result = Long.MIN_VALUE;
            for (int i = 0; i < (num / 2); i++) {
                result = Math.max(arr[i] + arr[index], result);
                index--;
            }
            result = Math.max(arr[num - 1], result);
        }
        System.out.println(result);

    }
}
