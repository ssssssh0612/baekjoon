package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기_2_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = arr[length - 1];

        while (left < right) {
            int mid = (left + right) / 2;

            long result = sum(mid, arr);

            if (result >= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left - 1);


    }
    public static long sum(int number , int [] arr){
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > number){
                sum += arr[i] - number;
            }
        }
        return sum;
    }
}
