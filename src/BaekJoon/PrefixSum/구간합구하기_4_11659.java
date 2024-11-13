package BaekJoon.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기_4_11659 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = input(br);
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            if (start == 0) {
                int result = Math.abs(arr[end]);
                System.out.println(result);
            } else {
                int result = Math.abs(arr[end] - arr[start - 1]);
                System.out.println(result);
            }
        }
    }

    public static int input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int testCase = Integer.parseInt(st.nextToken());
        arr = new int[length];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i > 0) {
                arr[i] += arr[i - 1];
            }
        }
        return testCase;
    }
}
