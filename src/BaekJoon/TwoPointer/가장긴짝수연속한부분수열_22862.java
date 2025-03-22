package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴짝수연속한부분수열_22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        // 짝수 개수
        int num2 = 0;
        // 홀수 개수
        int num1 = 0;
        if (arr[0] % 2 == 0) {
            // 짝수
            num2++;
        } else {
            // 홀수
            num1++;
        }
        int result = Integer.MIN_VALUE;
        while (end < length) {
            // 현재 홀수의 개수가 count 보다 많다면 start 올리고
            // 현재 홀수의 개수가 count 보다 적거나 같다면 End 올리고
            // 같다면 result 최신화
            if (num1 > count) {
                // num1이 카운트보다 크다면 start올리기
                if (checking(arr[start])) {
                    // 짝수
                    num2--;
                    start++;
                } else {
                    num1--;
                    start++;
                }
            } else if (num1 < count) {
                end++;
                if ( end < length ) {
                    if (checking(arr[end])) {
                        // 짝수
                        num2++;
                    } else {
                        num1++;
                    }
                }else{
                    result = Math.max(result, num2);
                    break;
                }
            } else {
                result = Math.max(result, num2);
                end++;
                if ( end < length ) {
                    if (checking(arr[end])) {
                        // 짝수
                        num2++;
                    } else {
                        num1++;
                    }
                }else{
                    break;
                }
            }
        }
        if(result == Integer.MIN_VALUE){
            System.out.println(0);
        }else{
            System.out.println(result);
        }
    }

    public static boolean checking(int num) {
        return num % 2 == 0;
    }
}

