package BaekJoon.구현;

import java.util.Scanner;

public class 호텔방번호_5671 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int result = 0;
            for (int i = n; i <= m; i++) {
                String value = String.valueOf(i);
                int[] arr = new int[10];
                boolean flag = true;
                for (int j = 0; j < value.length(); j++) {
                    int num = value.charAt(j) - '0';
                    arr[num]++;
                    if (arr[num] == 2) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    result++;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}