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
        while (end < a / 2 + 2 && start < a / 2 + 2) {
//            System.out.println("start Total = " + total);
            if(total == a) {
                result++;
                total -= start;
                start++;
            }else if (total < a){
                end++;
//                System.out.println("end = " + end);
                total += end;
//                System.out.println("total = " + total);
            }else if (total > a){
                total -= start;
                start++;
            }
        }
        System.out.println(result);
    }
}