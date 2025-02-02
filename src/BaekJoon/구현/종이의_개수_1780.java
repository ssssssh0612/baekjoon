package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이의_개수_1780 {
    static int zero = 0;
    static int one = 0;
    static int minusOne = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        arr = new int[length][length];
        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 2등분이 아닌 3등분 하는 문제
        partition(0,0,length);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    public static void partition(int y, int x, int size) {
        int number = arr[y][x];
        if (size == 1) {
            if (number == 0) {
                zero++;
            } else if (number == 1) {
                one++;
            } else {
                minusOne++;
            }
            return;
        }
        boolean flag = true;
        int newSize = size / 3;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                int checkNumber = arr[i][j];
                if (checkNumber != number) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }

        if (flag) {
            if (number == 0) {
                zero++;
            } else if (number == 1) {
                one++;
            } else {
                minusOne++;
            }
        }else{
            partition(y, x, newSize);
            partition(y, x + newSize, newSize);
            partition(y, x + (2 * newSize), newSize);

            partition(y + newSize, x, newSize);
            partition(y + newSize, x + newSize, newSize);
            partition(y + newSize, x + (2 * newSize), newSize);

            partition(y + (2 * newSize), x, newSize);
            partition(y + (2 * newSize), x + newSize, newSize);
            partition(y + (2 * newSize), x + (2 * newSize), newSize);

        }
    }
}
