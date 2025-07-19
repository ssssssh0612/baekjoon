package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기_2_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken()) - 1;
        int[] arr = new int[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max += arr[i];
        }

        if(count == 0){
            System.out.println(max);
            return;
        }

        long left = 1;
        long right = max;

        while(left < right){
            long mid = (left + right)/2;
            long target = sum(arr, mid);

            if( target > count ){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        System.out.println(left - 1);

    }
    public static long sum(int[] arr, long mid){
        long sum = 0;
//        System.out.println(mid + " " + sum);
        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] / mid + " ");
            sum += (arr[i] / mid);
        }
//        System.out.println();
        return sum;
    }
}


