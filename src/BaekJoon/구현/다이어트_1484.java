package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다이어트_1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[50_001];
        for (int i = 1; i <= 50000; i++) {
            arr[i] = (long) i * i;
        }
        int start = 1;
        int end = 2;
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        while (end > start && end < arr.length) {
            long num2 = arr[end];
            long num1 = arr[start];
//            System.out.println("end = " + end + " start = " + start);
            // 현재 내가 찾고자하는 값이 존재하는가 ?
            long check = num2 - num1;
            if (check == num) {
                flag = true;
                sb.append(end).append("\n");
            }

            if (check < num) {
                end++;
            } else {
                start++;
            }
        }
        if (flag) {
            System.out.print(sb);

        } else {
            System.out.println(-1);
        }
    }
}
