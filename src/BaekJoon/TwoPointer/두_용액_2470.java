package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두_용액_2470 {
    static int result;
    static int value1;
    static int value2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        value1 = arr[start];
        value2 = arr[end];
        result = Math.abs(value1 + value2);

        while(start < end){
            int num = arr[start] + arr[end];

            if(num == 0){
                System.out.println(arr[start] + " " + arr[end]);
                return;
            }

            if(result > Math.abs(num)){
                value1 = arr[start];
                value2 = arr[end];
                result = Math.abs(num);
            }

            if(num > 0){
                end--;
            }else{
                start++;
            }

        }

        System.out.println(value1 + " " + value2);
    }
}
