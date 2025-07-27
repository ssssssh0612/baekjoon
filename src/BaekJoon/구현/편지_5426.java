package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 편지_5426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            step(br.readLine());
        }
    }
    public static void step(String str){
        // 제곱수를 찾는 방법
        int length = 0;
        for (int i = 1; i <= 100; i++) {
            if(str.length() == i * i){
                length = i;
            }
        }
        char[][] charArr = new char[length][length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                charArr[i][j] = str.charAt(index);
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0; j < length; j++) {
                sb.append(charArr[j][i]);

            }
        }
        System.out.println(sb);
    }
}
