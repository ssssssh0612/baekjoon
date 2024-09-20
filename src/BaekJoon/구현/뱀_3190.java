package BaekJoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 뱀_3190 {
    // 우, 상, 좌, 하
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] snakeHeadPos = new int[3];
    // y, x, dir
    static List<int[]> snakeBody = new ArrayList<>();
    static int[][] graph;
    // 뱀이 몇초에 방향을 바꾸는지
    static List<int[]> snakeSecondDir = new ArrayList<>();
    // 총 지난 시간
    static int totalSecond;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        totalSecond = 0;
        snakeHeadPos[0] = 0;
        snakeHeadPos[1] = 0;
        snakeHeadPos[2] = 0;
        int n = sc.nextInt();
        graph = new int[n][n];
        int appleCount = sc.nextInt();
        for (int i = 0; i < appleCount; i++) {
            graph[sc.nextInt()][sc.nextInt()] = 1;
        }

        int snakeDirCount = sc.nextInt();
        // 처음엔 머리방향은 오른쪽
        for (int i = 0; i < snakeDirCount; i++) {
            int second = sc.nextInt();
            char move = sc.next().charAt(0);
            int moving = 0;
            // 1이면 오른쪽으로 90도 회전
            // 0이면 왼쪽으로 90도 회전
            if (move == 'D') {
                moving = 1;
            }
            snakeSecondDir.add(new int[]{second, moving});
        }
        boolean flag = true;
        // 뱀이 방향을 변경할때, 뒤에 따라오는 뱀의 몸이 어떻게 같이 유동적으로변하게 만들지 고민

        while (flag) {
            // 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
            // 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
            // 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
            // 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
            // 뱀이 방향을 바꿀 차례인지 아닌지 확인하기
            for (int i = 0; i < snakeSecondDir.size(); i++) {
                if(snakeSecondDir.get(i)[0] == totalSecond) {

                }
            }



            // 뱀의 이동
            int nowY = snakeHeadPos[0] + dy[snakeHeadPos[2]];
            int nowX = snakeHeadPos[1] + dx[snakeHeadPos[2]];

            // 몸 길이가 2 이상인경우와 몸 길이가 1인경우
            if(!snakeBody.isEmpty()){



                // 몸 길이가 2 이상인 경우
                // 앞으로 가려는데 벽인경우 , 내 몸인경우
                // 사과인경우
                if( nowY >= 0 && nowY < n && nowX >= 0 && nowX < n && graph[nowY][nowX] == 1 ){

                }
            }else{
                if( nowY >= 0 && nowY < n && nowX >= 0 && nowX < n && graph[nowY][nowX] == 1 ){
                    // 사과가 있는 경우
                    snakeBody.add(new int[]{snakeHeadPos[0], snakeHeadPos[1], snakeHeadPos[2]});
                    snakeHeadPos[0] = nowY;
                    snakeHeadPos[1] = nowX;
                }else if( nowY >= 0 && nowY < n && nowX >= 0 && nowX < n && graph[nowY][nowX] == 0 ){
                    // 사과가 아닌 경우
                    snakeHeadPos[0] = nowY;
                    snakeHeadPos[1] = nowX;
                }else{
                    // 벽인경우
                    // 나의 몸일경우는 경우의수가 생길 수 없음
                    flag = false;
                }

            }

            if( nowY >= 0 && nowX >= 0 && nowY < n && nowX < n ) {
                // 사과가 있다면
            }

            totalSecond++;
        }


    }

    public static int dirChecking(int dir, int number) {
        // 1이 오른쪽 0 이 왼쪽
        if (dir == 0) { // 오른쪽방향일경우
            if (number == 1) {
                dir = 3;
            } else {
                dir = 1;
            }
        } else if (dir == 1) {
            if (number == 1) {
                dir = 0;
            } else {
                dir = 2;
            }
        } else if (dir == 2) {
            if (number == 1) {
                dir = 1;
            } else {
                dir = 3;
            }
        } else {
            if (number == 1) {
                dir = 2;
            } else {
                dir = 0;
            }
        }
        return dir;
    }
}
