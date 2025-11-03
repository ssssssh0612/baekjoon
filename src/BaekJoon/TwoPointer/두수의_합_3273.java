package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의_합_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int checkNum = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int start = 0;
        int end = n - 1;
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
        int result = 0;
        while(end > start){
            int sum = arr[start] + arr[end];
//            System.out.println(start + " " + end);
            if(sum == checkNum){
                result++;
            }
            if(sum <= checkNum){
                start++;
            }else{
                end--;
            }
        }
        System.out.println(result);
    }
}

