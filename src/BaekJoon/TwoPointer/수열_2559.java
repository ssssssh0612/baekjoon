package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 수열_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int maxNum = Integer.MIN_VALUE;
        int start = 0;
        int end = m - 1;
        int result = 0;
        for (int i = 0; i <= end; i++) {
            result += arr[i];
        }
        maxNum = Math.max(result, maxNum);
        while (end < n) {
            result -= arr[start];
            start++;
            end++;
            if(end < n ){
                result += arr[end];
                maxNum = Math.max(result, maxNum);
            }else{
                break;
            }
        }
        System.out.println(maxNum);
    }
}
