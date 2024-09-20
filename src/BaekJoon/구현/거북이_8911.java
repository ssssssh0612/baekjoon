package BaekJoon.구현;

import java.util.Scanner;

public class 거북이_8911 {
    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    // 상
    static int dir0 = 0;
    // 하
    static int dir1 = 0;
    // 좌
    static int dir2 = 0;
    // 우
    static int dir3 = 0;
    // 방향 결정
    static int dir = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            String a = sc.next();
            for (int j = 0; j < a.length(); j++) {
                move(a.charAt(j));
            }
        }
    }
    public static void move(char a) {
        // F: 한 눈금 앞으로
        // B: 한 눈금 뒤로
        // L: 왼쪽으로 90도 회전
        // R: 오른쪽으로 90도 회전
        if (a == 'F') {
            switch (dir){
                // 북
                case 0:
                    // 남
                case 1:
                    // 서
                case 2:
                    // 동
                case 3:
            }
        } else if (a == 'B') {
            switch (dir) {
                case 0:

                case 1:
                case 2:
                case 3:
            }
        } else if (a == 'L') {

        } else if (a == 'R') {

        }

    }

    public static void direction(int dir) {

    }
}
