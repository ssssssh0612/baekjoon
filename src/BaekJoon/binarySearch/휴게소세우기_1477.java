package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 휴게소세우기_1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 2];
        st = new StringTokenizer(br.readLine());
        arr[0] = 0;
        arr[1] = k;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 1;
        int right = k - 1;

        while(left < right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for(int i=1; i<arr.length; i++) {
                sum+=(arr[i] - arr[i-1] - 1) / mid;
            }
//            System.out.println(left + " " + mid + " " + right);
            if(sum <= m){
                right = mid;
            }else{
                left = mid + 1;
            }

        }
        System.out.println(left);


    }
}
