package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홀수홀릭호석_20164 {
    static String number;
    static int maxNum = Integer.MIN_VALUE;
    static int minNum = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = br.readLine();
        slice(number, 0);
        System.out.println(minNum + " " + maxNum);
    }

    public static void slice(String number, int count){
        int size = number.length();
        int check = 0;
        for (int i = 0; i < size; i++) {
            int num = number.charAt(i) - '0';
            if(num % 2 == 1){
                check++;
            }
        }

        if(size == 1){
            maxNum = Math.max(maxNum, count + check);
            minNum = Math.min(minNum, count + check);
        }

        if(size == 2){
            int num1 = number.charAt(0) - '0';
            int num2 = number.charAt(1) - '0';
            int result = num1 + num2;
            slice(String.valueOf(result), count + check);
        }

        if(size >= 3){
            // 1 2 3 4 5
            //  0 1 2 3
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size - 1; j++) {
                    int num1 = 0;
                    StringBuilder sb1 = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    StringBuilder sb3 = new StringBuilder();
                    for (int k = 0; k <= i; k++) {
                        sb1.append(number.charAt(k));
                    }
                    num1 += Integer.parseInt(sb1.toString());

                    for (int k = i + 1; k <= j; k++) {
                        sb2.append(number.charAt(k));
                    }
                    num1 += Integer.parseInt(sb2.toString());

                    for (int k = j + 1; k < size; k++) {
                        sb3.append(number.charAt(k));
                    }
                    num1 += Integer.parseInt(sb3.toString());

                    slice(String.valueOf(num1), count + check);
                }
            }
        }
    }
}
