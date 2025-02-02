package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리_1992 {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        arr = new int[length][length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            String str = br.readLine();
            for (int j = 0; j < length; j++) {
                char ch = str.charAt(j);
                if (ch == '0') {
                    count++;
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }



        partition(0, 0, length);
        System.out.println(sb);

    }

    public static void partition(int startY, int startX, int size) {
        if (size == 1) {
            sb.append(arr[startY][startX]);
            return;
        }
        int newSize = size / 2;
        int number = arr[startY][startX];
        boolean flag = false;
        for (int i = startY; i < startY + size; i++) {
            for (int j = startX; j < startX + size; j++) {
                if (arr[i][j] != number) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        if (!flag) {
            sb.append(number);
        } else {
            sb.append("(");
            partition(startY, startX, newSize);
            partition(startY, startX + newSize, newSize);
            partition(startY + newSize, startX, newSize);
            partition(startY + newSize, startX + newSize, newSize);
            sb.append(")");
        }
    }
}
