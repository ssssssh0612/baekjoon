package BaekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 거스름돈_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int count = 0;
        while (true) {
            if (number % 5 == 0) {
                count += number / 5;
                System.out.println(count);
                break;
            } else {
                number -= 2;
                count++;
            }
            if (number < 0) {
                System.out.println(-1);
                break;
            }
        }
    }
}