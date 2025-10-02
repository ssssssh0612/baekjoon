package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int count =0;
        int start = 0;
        int end = arr.length - 1;
        int num = arr[start] + arr[end];
        while(end > start){
            // 숫자가 크면
            if(num == result){
                count++;
                end--;
                start++;
                num = arr[start] + arr[end];
                continue;
            }

            if(num > result){
                num -= arr[end];
                end--;
                num += arr[end];
                continue;
            }

            num -= arr[start];
            start++;
            num += arr[start];

        }
        System.out.println(count);
    }
}

//16
//3 5 6 16 18
