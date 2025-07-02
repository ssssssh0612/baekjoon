package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기_2805 {
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
        int min = 0;
        int max = arr[length - 1];

        while (min < max) {
            int mid = (min + max) / 2;

            long result = check(mid, arr);

            if (result >= target) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min - 1);


    }
    public static long check(int number , int [] arr ){
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > number){
                sum += arr[i] - number;
            }
        }
        return sum;
    }
}
