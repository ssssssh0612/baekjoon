package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게으른_백곰_10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[1000001];
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            arr[index] = value;
        }
        // m은 범위인데
        if((m * 2) + 1 >= arr.length){
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            System.out.println(sum);
            return;
        }
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < m * 2 + 1; i++) {
            sum += arr[i];
        }
        int end = m * 2 + 1;
        int start = 1;
        result = Math.max(sum, result);
        while(end < arr.length){
            sum -= arr[start - 1];
            sum += arr[end];

            result = Math.max(sum, result);
            end++;
            start++;
        }
        System.out.println(result);

    }
}
