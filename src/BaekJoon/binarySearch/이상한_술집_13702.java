package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이상한_술집_13702 {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1 - 최대값
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }
        if(n == 1 && m == 1){
            System.out.println(arr[0]);
            return;
        }
        while(left < right){
            int mid = (left + right) / 2;
            long count = check(arr, mid);
            if(count < m){
                // 숫자가 작아져야함
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }
    public static long check(int[] arr, int num){
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i] / num;
        }
        return count;
    }
}
