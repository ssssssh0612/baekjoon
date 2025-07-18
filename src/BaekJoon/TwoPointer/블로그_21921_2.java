package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블로그_21921_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
        }
        max = sum;
        int resultCount = 1;
        int start = 1;
        int end = length;
        while(end < arr.length){
            int newMax = sum - arr[start - 1] + arr[end];

            if(newMax > max){
                System.out.println(start + " " + end);
                resultCount = 1;
                max = newMax;
            }else if(newMax == max){
                resultCount++;
            }
            sum = newMax;
            start++;
            end++;
        }

        if(max == 0){
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(resultCount);
    }
}
