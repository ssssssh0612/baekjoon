package BaekJoon.구현;

import java.util.Scanner;

public class 로봇청소기_14503 {
    // 북, 동, 남, 서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    // 상 하 좌 우
    // 0,0,-1,1
    // -1,1,0,0
    static int dir;
    static int graph[][];
    //현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
    //현재 칸의 주변 칸 중 청소되지 않은 빈 칸이 없는 경우,
    //바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
    //바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
    //현재 칸의 주변 칸 중 청소되지 않은 빈 칸이 있는 경우,
    //반시계 방향으로
    //$90^\circ$ 회전한다.
    //바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
    //1번으로 돌아간다.
    static int[] robotPos = new int[2];
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int y = sc.nextInt();
        int x = sc.nextInt();
        graph = new int[y][x];
        robotPos[0] = sc.nextInt();
        robotPos[1] = sc.nextInt();
        dir = sc.nextInt();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        // 1 은 벽 , 0 은 아직 청소 안됨
        // 100 은 청소완료
        while (flag) {
            boolean flag2 = false;
            // 1. 현재 칸이 청소되지 않은 경우 현재 칸 청소
            if (graph[robotPos[0]][robotPos[1]] == 0) {
                graph[robotPos[0]][robotPos[1]] = 100;
            }

            for (int i = 0; i < 4; i++) {
                int nowY = robotPos[0] + dy[i];
                int nowX = robotPos[1] + dx[i];
                if (nowY >= 0 && nowY < graph.length && nowX >= 0 && nowX < graph[0].length
                        && graph[nowY][nowX] == 0) {
                    flag2 = true;
                    break;
                }
            }
            if (flag2) {
                // 빈칸이 있는경우
                // 반시계방향으로 90도 회전
                if (dir != 0) {
                    dir = dir - 1;
                } else {
                    dir = 3;
                }
                int nowY = robotPos[0] + dy[dir];
                int nowX = robotPos[1] + dx[dir];
                // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                if (nowY >= 0 && nowY < graph.length &&
                        nowX >= 0 && nowX < graph[0].length && graph[nowY][nowX] == 0) {
                    robotPos[0] = nowY;
                    robotPos[1] = nowX;
                    // 1번으로 돌아감
                }
            } else {
                // 빈칸이 없는경우
                // 후진할 수 있다면 한칸 후진하고 1번으로 돌아간다
                switch (dir) {
                    case 0:
                        dir = 2;
                        int nowY1 = robotPos[0] + dy[dir];
                        int nowX1 = robotPos[1] + dx[dir];
                        if (nowY1 >= 0 && nowX1 >= 0 && nowY1 < graph.length &&
                                nowX1 < graph[0].length && graph[nowY1][nowX1] != 1) {
                            robotPos[0] = nowY1;
                            robotPos[1] = nowX1;
                            dir = 0;
                            continue;
                        } else {
                            flag = false;
                        }
                        break;
                    case 1:
                        dir = 3;
                        int nowY2 = robotPos[0] + dy[dir];
                        int nowX2 = robotPos[1] + dx[dir];
                        if (nowY2 >= 0 && nowX2 >= 0 && nowY2 < graph.length && nowX2 < graph[0].length && graph[nowY2][nowX2] != 1) {
                            robotPos[0] = nowY2;
                            robotPos[1] = nowX2;
                            dir = 1;
                            continue;
                        } else {
                            flag = false;
                        }
                        break;
                    case 2:
                        dir = 0;
                        int nowY3 = robotPos[0] + dy[dir];
                        int nowX3 = robotPos[1] + dx[dir];
                        if (nowY3 >= 0 && nowX3 >= 0 && nowY3 < graph.length && nowX3 < graph[0].length && graph[nowY3][nowX3] != 1) {
                            robotPos[0] = nowY3;
                            robotPos[1] = nowX3;
                            dir = 2;
                            continue;
                        } else {
                            flag = false;
                        }
                        break;
                    case 3:
                        dir = 1;
                        int nowY4 = robotPos[0] + dy[dir];
                        int nowX4 = robotPos[1] + dx[dir];
                        if (nowY4 >= 0 && nowX4 >= 0 && nowY4 < graph.length && nowX4 < graph[0].length && graph[nowY4][nowX4] != 1) {
                            robotPos[0] = nowY4;
                            robotPos[1] = nowX4;
                            dir = 3;
                            continue;
                        } else {
                            flag = false;
                        }
                        break;
                }
            }
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(graph[i][j] == 100){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}

