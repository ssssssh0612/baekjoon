package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속된자연수의합수학_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        a = a - 1;
        int count = 2;
        boolean flag = true;
        int result = 0;
        while(a > 0) {
            a = a - count;
            if( a % count == 0 ) {
                result++;
            }
            count++;
        }
        System.out.println(result);
















//        int i = 2;
//        boolean flag = true;
//        int result = 0;
//        while (flag) {
//            int total = 0;
//            for (int j = 1; j <= i; j++) {
//                total += j;
//            }
//            if (total > a) {
//                flag = false;
//                break;
//            }
//
//            int number = a - total;
//            if (number % i == 0) {
//                result++;
//            }
//            i++;
//        }
    }
}
