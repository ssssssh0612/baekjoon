package BaekJoon.구현;

import java.util.Scanner;

public class 로봇_13567 {
    // 로봇의 위치
    static int[] robotPos;
    static int[][] arr;
    // 북, 남, 서, 동
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    // 시작방향은 동쪽
    // TURN 0 현재위치에서 왼쪽으로 90도
    // TURN 1 현재위치에서 오른쪽으로 90도
    static int dir = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        robotPos = new int[]{n, 0};
        arr = new int[n + 1][n + 1];
        int testCase = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testCase; i++) {
            order(sc.next(), sc.nextInt());
            sc.nextLine();
            if(!(robotPos[0] >= 0 && robotPos[0] <= n && robotPos[1] >= 0 && robotPos[1] <= n)){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(robotPos[1]+" "+(n-robotPos[0]));
    }

    public static void order(String content, int number) {
        // 현재 방향으로 몇 움직여라
        if (content.equals("MOVE")) {
            for (int i = 0; i < number; i++) {
                robotPos[0] = dy[dir] + robotPos[0];
                robotPos[1] = dx[dir] + robotPos[1];
            }
        } else {
            // 북 남 서 동
            // 0 1 2 3
            switch (dir) {
                case 0: // 북
                    if (number == 0) {
                        dir = 2;
                        break;
                    } else {
                        dir = 3;
                        break;
                    }
                case 1: // 남
                    if (number == 0) {
                        dir = 3;
                        break;
                    } else {
                        dir = 2;
                        break;
                    }
                case 2: // 서
                    if (number == 0) {
                        dir = 1;
                        break;
                    } else {
                        dir = 0;
                        break;
                    }
                case 3: // 동
                    if (number == 0) {
                        dir = 0;
                        break;
                    } else {
                        dir = 1;
                        break;
                    }
            }
        }
    }
}

