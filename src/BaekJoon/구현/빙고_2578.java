package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙고_2578 {
    static int[][] arr;
    static int RESULT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
        int index = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                index++;
                int number = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (arr[k][l] == number) {
                            arr[k][l] = 0;
                        }
                        bingo();
                        if(RESULT >= 3 ){
                            System.out.println(index);
                            return;
                        }
                        RESULT = 0;
                    }
                }
            }
        }
    }

    public static void bingo() {
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == 0) {
                    count++;
                } else if (arr[i][j] > 0) {
                    break;
                }

                if (count == 5) {
                    RESULT++;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] == 0) {
                    count++;
                } else if (arr[j][i] > 0) {
                    break;
                }

                if (count == 5) {
                    RESULT++;
                }
            }
        }
        int count1 = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[i][i] == 0) {
                count1++;
            }
            if (count1 == 5) {
                RESULT++;
            }
        }
        int index = 4;
        int count2 = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[index][i] == 0) {
                count2++;
            }
            index--;
            if (count2 == 5) {
                RESULT++;
            }
        }
    }
}
