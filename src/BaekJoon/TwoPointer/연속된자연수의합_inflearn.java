package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class 연속된자연수의합_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 2;
        int total = 3;
        int result = 0;
        while (end < a && start < a) {
            if (total == a) {
                result++;
                if( end - start > 0 ){
                    start -= total;
                    start++;
                    end++;
                    end += total;
                }
            } else if (total < a/2 + 1) {
                end++;
                end += total;
            } else if (total > a/2 + 1 ) {
                start -= total;
                start++;
            } else {
                end++;
                end += total;
            }
        }
        System.out.println(result);
    }
}