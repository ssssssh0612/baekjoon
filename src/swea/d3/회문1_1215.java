package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문1_1215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int length = Integer.parseInt(br.readLine());
            char[][] chArr = new char[8][8];
            for (int j = 0; j < 8; j++) {
                String str = br.readLine();
                for (int k = 0; k < 8; k++) {
                    char ch = str.charAt(k);
                    chArr[j][k] = ch;
                }
            }

            if (length == 1) {
                System.out.println("#" + (i + 1) + " " + 64);
            } else if (length == 2) {
                System.out.println("#" + (i + 1) + " " + check2(chArr));
            } else {
                System.out.println("#" + (i + 1) + " " + check(chArr, length));
            }
        }
    }

    public static int check2(char[][] chArr) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char ch = chArr[i][j];
                if (checking(i, j + 1) && ch == chArr[i][j + 1]) {
                    count++;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char ch = chArr[j][i];
                if (checking(i + 1, j) && ch == chArr[i + 1][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && y < 8 && x >= 0 && x < 8;
    }

    public static int check(char[][] chArr, int length) {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int count = 0;
                if (checking(i, j + length - 1)) {
                    for (int k = 0; k < length / 2; k++) {
                        if (chArr[i][j + k] == chArr[i][j + (length - 1) - k]) {
                            count++;
                        }
                    }
                    if (count == length/2) {
                        result++;

                    }
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int count = 0;
                for (int k = 0; k < length / 2; k++) {
                    if (checking(j + k, i) && checking((length - 1) - k + j, i) &&
                            chArr[j + k][i] == chArr[(length - 1) - k + j][i]) {
                        count++;
                    }
                }
                if (count == length/2) {
                    result++;
                }
            }
        }
        return result;
    }
}
